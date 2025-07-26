package com.application.simpleorderingsystem.services;

import com.application.simpleorderingsystem.entities.User;
import com.application.simpleorderingsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> resUser = userRepository.findById(id);
        return resUser.get();
    }


}
