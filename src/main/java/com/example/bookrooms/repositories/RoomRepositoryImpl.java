package com.example.bookrooms.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.bookrooms.models.Room;

public class RoomRepositoryImpl implements RoomRepository{

    List<Room> roomDb = new ArrayList<>();
    @Override
    public Room save(Room room) {
        roomDb.add(room);
        return room;
    }

    @Override
    public Optional<Room> findById(long roomId) {
        return roomDb.stream().filter(room -> room.getId() == roomId).findFirst();
    }
    
}
