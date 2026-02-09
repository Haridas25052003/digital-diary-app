package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.model.User;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(int id);

    Optional<User> getUserByEmail(String email);

    boolean existsByEmail(String email);
}
