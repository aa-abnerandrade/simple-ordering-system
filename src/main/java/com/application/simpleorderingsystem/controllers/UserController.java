package com.application.simpleorderingsystem.controllers;

import com.application.simpleorderingsystem.entities.User;
import com.application.simpleorderingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user) {
        User newUser = userService.insert(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).body(newUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateById(id, user);
//        if (updatedUser == null) {
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok().body(updatedUser);
    }


}
