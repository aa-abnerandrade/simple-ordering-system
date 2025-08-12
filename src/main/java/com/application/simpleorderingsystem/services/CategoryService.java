package com.application.simpleorderingsystem.services;

import com.application.simpleorderingsystem.entities.Category;
import com.application.simpleorderingsystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> resCategory = categoryRepository.findById(id);
        return resCategory.get();
    }
}
