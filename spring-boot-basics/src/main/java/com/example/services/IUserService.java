package com.example.services;

import com.example.models.User;

import java.util.List;

public interface IUserService {
    User findOne(Long id);
    List<User> findAll();
    User saveUser(User user);
}
