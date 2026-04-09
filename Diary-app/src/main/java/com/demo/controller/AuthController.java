package com.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.exception.BadRequestException;
import com.demo.exception.ResourceNotFoundException;
import com.demo.model.User;
import com.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")   // Allow frontend calls during development
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final UserService userService;

    // ✅ Constructor Injection (no @Autowired needed on constructor)
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ✅ REGISTER USER
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        logger.info("Registering user with email: {}", user.getEmail());

        if (userService.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already registered: " + user.getEmail());
        }

        User savedUser = userService.saveUser(user);
        logger.info("User registered with ID: {}", savedUser.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
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
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

        return ResponseEntity.ok(user);
    }

    // ✅ LOGIN — find user by email + validate password
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginRequest) {
        logger.info("Login attempt for email: {}", loginRequest.getEmail());

        User user = userService.getUserByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("No account found with email: " + loginRequest.getEmail()));

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new BadRequestException("Incorrect password. Please try again.");
        }

        logger.info("Login successful for user ID: {}", user.getId());
        return ResponseEntity.ok(user);
    }
}