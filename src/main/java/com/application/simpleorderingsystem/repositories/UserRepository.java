package com.application.simpleorderingsystem.repositories;

import com.application.simpleorderingsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
