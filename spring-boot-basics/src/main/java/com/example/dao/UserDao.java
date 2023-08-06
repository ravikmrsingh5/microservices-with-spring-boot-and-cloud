package com.example.dao;

import com.example.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class UserDao implements IUserDao{

    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1L, "Ravi", LocalDate.of(1992, 01, 12)));
        users.add(new User(2L, "Shweta", LocalDate.of(1998, 01, 25)));
        users.add(new User(3L, "Atharva", LocalDate.of(2021, 06, 21)));
    }
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findOne(Long id) {
        try {
            return users.stream().filter(user -> user.getId().equals(id))
                    .findFirst()
                    .orElseThrow();
        } catch (NoSuchElementException exception) {
            throw new UserNotFound(String.format("User with userId %d not found", id));
        }
    }

    @Override
    public User save(User user) {
        user.setId((long)users.size() + 1);
        users.add(user);
        return user;
    }
}
