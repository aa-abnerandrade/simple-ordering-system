package com.application.simpleorderingsystem.controllers;

import com.application.simpleorderingsystem.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAllUsers() {
        // Logic to retrieve all users
        User newUser = new User(1L, "John Doe", "john@email.com", "1234567890", "password123");
        return ResponseEntity.ok().body(newUser);
    }
}
