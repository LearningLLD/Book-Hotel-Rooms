package com.example.bookrooms.dtos;

import java.util.Map;

public class MakeBookingRequestDto {
    // user id of customer
    private long userId;
    // room id , no Of such room booked
    private Map<Long, Integer> bookedRooms;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Map<Long, Integer> getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(Map<Long, Integer> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }
}
