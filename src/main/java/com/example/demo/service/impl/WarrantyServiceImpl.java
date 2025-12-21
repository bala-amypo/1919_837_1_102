package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.entity.Warranty;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.WarrantyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository warrantyRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public WarrantyServiceImpl(WarrantyRepository warrantyRepository,
                               UserRepository userRepository,
                               ProductRepository productRepository) {
        this.warrantyRepository = warrantyRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        if (warranty.getStartDate() == null || warranty.getEndDate() == null) {
            throw new IllegalArgumentException("startDate and endDate are required");
        }
        if (warranty.getEndDate().isBefore(warranty.getStartDate())) {
            throw new IllegalArgumentException("endDate must be after startDate");
        }

        warranty.setUser(user);
        warranty.setProduct(product);
        return warrantyRepository.save(warranty);
    }

    @Override
    public Warranty getWarranty(Long warrantyId) {
        return warrantyRepository.findById(warrantyId)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));
    }

    @Override
    public List<Warranty> getUserWarranties(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found");
        }
        return warrantyRepository.findByUserId(userId);
    }
}