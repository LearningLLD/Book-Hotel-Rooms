package com.example.bookrooms.repositories;

import java.util.ArrayList;
import java.util.List;

import com.example.bookrooms.models.Booking;

public class BookingRepositoryImpl implements BookingRepository{

    List<Booking> bookingDb = new ArrayList<>();
    @Override
    public Booking save(Booking booking) {
        bookingDb.add(booking);
        return booking;
    }
    
}
