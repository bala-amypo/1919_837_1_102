package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository repo) {
        this.productRepository = repo;
    }

    public Product addProduct(Product p) {
        if (p.getModelNumber() == null || p.getModelNumber().isBlank()) {
            throw new IllegalArgumentException("Model number required");
        }
        if (p.getCategory() == null || p.getCategory().isBlank()) {
            throw new IllegalArgumentException("Category required");
        }
        return productRepository.save(p);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
