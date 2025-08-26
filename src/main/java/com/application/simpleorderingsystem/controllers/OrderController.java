package com.application.simpleorderingsystem.controllers;

import com.application.simpleorderingsystem.entities.Order;
import com.application.simpleorderingsystem.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping
    public ResponseEntity<List<Order>> findAllOrders() {
        List<Order> listAllOrders = orderService.findAll();
        return ResponseEntity.ok().body(listAllOrders);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
