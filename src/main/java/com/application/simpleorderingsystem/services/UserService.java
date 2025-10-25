package com.application.simpleorderingsystem.services;

import com.application.simpleorderingsystem.entities.User;
import com.application.simpleorderingsystem.repositories.UserRepository;
import com.application.simpleorderingsystem.services.exceptions.DatabaseException;
import com.application.simpleorderingsystem.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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
        return resUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        try {
            User resUser = findById(id);
            userRepository.deleteById(resUser.getId());
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User updateById(Long id, User updatedUser) {
        try {
            User refUser = userRepository.getReferenceById(id);
            updateData(refUser, updatedUser);
            return userRepository.save(updatedUser);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User oldUser, User newUser) {
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPhone(newUser.getPhone());
    }


}
