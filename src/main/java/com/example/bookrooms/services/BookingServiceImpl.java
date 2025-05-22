package com.example.bookrooms.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.example.bookrooms.exceptions.InvalidRoomException;
import com.example.bookrooms.exceptions.UserNotFoundException;
import com.example.bookrooms.models.Booking;
import com.example.bookrooms.models.CustomerSession;
import com.example.bookrooms.models.CustomerSessionStatus;
import com.example.bookrooms.models.Room;
import com.example.bookrooms.models.User;
import com.example.bookrooms.repositories.BookingRepository;
import com.example.bookrooms.repositories.CustomerSessionRepository;
import com.example.bookrooms.repositories.RoomRepository;

import com.example.bookrooms.repositories.UserRepository;

public class BookingServiceImpl implements BookingService{

    private UserRepository userRepository;
    private RoomRepository roomRepository;
    private BookingRepository bookingRepository;
    private CustomerSessionRepository customerSessionRepository;

    public BookingServiceImpl(UserRepository userRepository, RoomRepository roomRepository, BookingRepository bookingRepository, CustomerSessionRepository customerSessionRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.customerSessionRepository = customerSessionRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking makeBooking(long userId, Map<Long, Integer> roomsToBeBooked)
            throws UserNotFoundException, InvalidRoomException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("User Not Found");
        }
       
        Map<Room, Integer> bookingRoom = new HashMap<>();

        for(Long id : roomsToBeBooked.keySet()) {
            Optional<Room> optionalRoom = roomRepository.findById(id);
            if(optionalRoom.isEmpty()){
                throw new InvalidRoomException("No Valid Room Found");
            }
            bookingRoom.put(optionalRoom.get(), roomsToBeBooked.get(id));
        }

        CustomerSession session = new CustomerSession();
        session.setCustomerSessionStatus(CustomerSessionStatus.ACTIVE);
        session.setUser(optionalUser.get());

        customerSessionRepository.save(session);

        Booking booking = new Booking();
        booking.setBookedRooms(bookingRoom);
        booking.setCustomerSession(session);

        return bookingRepository.save(booking);
    }
    
}
