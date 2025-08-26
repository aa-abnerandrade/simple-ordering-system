package com.application.simpleorderingsystem.controllers;

import com.application.simpleorderingsystem.entities.Product;
import com.application.simpleorderingsystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        // Logic to retrieve all products
        List<Product> listAllProducts = productService.findAll();
        return ResponseEntity.ok().body(listAllProducts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        // Logic to retrieve all products
        Product resProduct = productService.findById(id);
        return ResponseEntity.ok().body(resProduct);
    }
}
