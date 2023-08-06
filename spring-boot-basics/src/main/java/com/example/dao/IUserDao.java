package com.example.dao;

import com.example.models.User;
import java.util.List;

public interface IUserDao {
    List<User> findAll();
    User findOne(Long id);
    User save(User user);
}
