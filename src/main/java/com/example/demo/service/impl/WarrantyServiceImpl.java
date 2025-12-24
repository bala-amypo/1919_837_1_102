package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;

import java.util.List;

public class WarrantyServiceImpl {

    private final WarrantyRepository warrantyRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public WarrantyServiceImpl(WarrantyRepository w, UserRepository u, ProductRepository p) {
        this.warrantyRepository = w;
        this.userRepository = u;
        this.productRepository = p;
    }

    public Warranty registerWarranty(Long userId, Long productId, Warranty w) {
        if (!w.getExpiryDate().isAfter(w.getPurchaseDate())) {
            throw new IllegalArgumentException("Expiry date must be after purchase date");
        }
        if (warrantyRepository.existsBySerialNumber(w.getSerialNumber())) {
            throw new IllegalArgumentException("Serial number must be unique");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        w.setUser(user);
        w.setProduct(product);
        return warrantyRepository.save(w);
    }

    public Warranty getWarranty(Long id) {
        return warrantyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warranty not found"));
    }

    public List<Warranty> getUserWarranties(Long userId) {
        return warrantyRepository.findByUserId(userId);
    }
}
