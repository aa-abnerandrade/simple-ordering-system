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

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        User resUser = findById(id);
        userRepository.deleteById(resUser.getId());
    }

    public User updateById(Long id, User updatedUser) {
        User refUser = userRepository.getReferenceById(id);
        updateData(refUser, updatedUser);
        return userRepository.save(updatedUser);
    }

    private void updateData(User oldUser, User newUser) {
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPhone(newUser.getPhone());
    }


}
