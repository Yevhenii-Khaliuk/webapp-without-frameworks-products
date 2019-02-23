package com.khaliuk.service;

import com.khaliuk.model.User;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> authorize(User user) {
        user.setFirstName("Anton");
        return Optional.of(user); // empty(); to get error
    }
}
