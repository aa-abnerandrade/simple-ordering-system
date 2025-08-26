package com.application.simpleorderingsystem.controllers;

import com.application.simpleorderingsystem.entities.User;
import com.application.simpleorderingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        // Logic to retrieve all users
        //User newUser = new User(1L, "John Doe", "john@email.com", "1234567890", "password123");
        List<User> listAllUsers = userService.findAll();
        return ResponseEntity.ok().body(listAllUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
