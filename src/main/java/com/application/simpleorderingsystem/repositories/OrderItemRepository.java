package com.application.simpleorderingsystem.repositories;

import com.application.simpleorderingsystem.entities.OrderItem;
import com.application.simpleorderingsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
