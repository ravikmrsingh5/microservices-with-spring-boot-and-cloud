package com.example.services;

import com.example.dao.IUserDao;
import com.example.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements IUserService{

    IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findOne(Long id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }


}
