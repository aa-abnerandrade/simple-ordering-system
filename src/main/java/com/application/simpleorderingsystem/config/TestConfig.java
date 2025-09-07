package com.application.simpleorderingsystem.config;

import com.application.simpleorderingsystem.entities.*;
import com.application.simpleorderingsystem.entities.enums.OrderStatus;
import com.application.simpleorderingsystem.repositories.*;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria Brown", "maria@email.com", "988888888", "123456");
        User user2 = new User(null, "Alex Green", "alex@email.com", "977777777", "123456");
        Order order1 = new Order(null, Instant.parse("2025-01-01T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user1);
        Order order2 = new Order(null, Instant.parse("2025-02-01T03:42:10Z"), OrderStatus.SHIPPED, user2);
        Order order3 = new Order(null, Instant.parse("2025-03-01T09:42:10Z"), OrderStatus.CANCELED, user1);
        Category category1 = new Category(null, "Eletronics");
        Category category2 = new Category(null, "Tools");
        Category category3 = new Category(null, "Computers");
        Category category4 = new Category(null, "Books");
        Product product1 = new Product(null, "Computer", "Good computer", 2000.0, "");
        Product product2 = new Product(null, "Cell Phone", "Good cell phone", 1500.0, "");
        Product product3 = new Product(null, "Tool 1", "Good tool", 100.0, "");
        Product product4 = new Product(null, "Tool 2", "Another good tool", 150.0, "");
        Product product5 = new Product(null, "Book 1", "Interesting book", 50.0, "");

        product1.getCategories().add(category1);
        product1.getCategories().add(category3);
        product2.getCategories().add(category1);
        product3.getCategories().add(category1);
        product3.getCategories().add(category2);
        product4.getCategories().add(category2);
        product5.getCategories().add(category4);
        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3, category4));
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        //category1.getProducts().addAll(Arrays.asList(product1, product2));

        OrderItem oi1 = new OrderItem(order1, product1, 2, product1.getPrice());
        OrderItem oi2 = new OrderItem(order1, product3, 1, product3.getPrice());
        OrderItem oi3 = new OrderItem(order2, product3, 2, product3.getPrice());
        OrderItem oi4 = new OrderItem(order3, product5, 2, product5.getPrice());
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
