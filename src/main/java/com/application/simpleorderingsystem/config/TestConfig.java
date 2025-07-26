package com.application.simpleorderingsystem.config;

import com.application.simpleorderingsystem.entities.Order;
import com.application.simpleorderingsystem.entities.User;
import com.application.simpleorderingsystem.repositories.OrderRepository;
import com.application.simpleorderingsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria Brown", "maria@email.com", "988888888", "123456");
        User user2 = new User(null, "Alex Green", "alex@email.com", "977777777", "123456");
        Order order1 = new Order(null, Instant.parse("2025-01-01T19:53:07Z"), user1);
        Order order2 = new Order(null, Instant.parse("2025-02-01T03:42:10Z"), user2);
        Order order3 = new Order(null, Instant.parse("2025-03-01T09:42:10Z"), user1);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
