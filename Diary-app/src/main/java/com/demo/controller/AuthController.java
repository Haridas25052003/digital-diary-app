package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.model.User;
import com.demo.service.UserService;

@RestController
@RequestMapping("/api/auth")   
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthController {

    @Autowired
    private UserService us;
    

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return us.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return us.findByEmail(user.getEmail())
                 .stream()
                 .findFirst()
                 .orElse(null);
    }


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return us.findAll();
    }

    @GetMapping("/req1/{email}")
    public List<User> getUserByEmail(@PathVariable String email) {
        return us.findByEmail(email);
    }

    @GetMapping("/req2/{id}")
    public List<User> getUserById(@PathVariable int id) {
        return us.findById(id);
    }

    @GetMapping("/req3/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return us.findByName(name);
    }
}
