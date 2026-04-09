package com.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.model.User;
import com.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final UserService userService;

    // ✅ Constructor Injection
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ✅ CREATE USER
    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {

        logger.info("Creating user with email: {}", user.getEmail());

        // ✅ Prevent duplicate email
        if (userService.existsByEmail(user.getEmail())) {
            logger.warn("Attempt to register duplicate email: {}", user.getEmail());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email already exists!");
        }

        User savedUser = userService.saveUser(user);

        logger.info("User created successfully with ID: {}", savedUser.getId());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }

    // ✅ GET ALL USERS
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        logger.info("Fetching all users");

        return ResponseEntity.ok(userService.getAllUsers());
    }

    // ✅ GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {

        logger.info("Fetching user by ID: {}", id);

        User user = userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        return ResponseEntity.ok(user);
    }

    // ✅ LOGIN (GET BY EMAIL)
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {

        logger.info("Fetching user by email: {}", email);

        User user = userService.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        return ResponseEntity.ok(user);
    }
}