package com.example.bookrooms.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.bookrooms.models.User;

public class UserRepositoryImpl implements UserRepository{

    List<User> userDb = new ArrayList<>();
    @Override
    public Optional<User> findById(long id) {
        return userDb.stream().filter(user -> user.getId() == id).findFirst();
    }

    @Override
    public User save(User user) {
        userDb.add(user);
        return user;
    }
    
}
