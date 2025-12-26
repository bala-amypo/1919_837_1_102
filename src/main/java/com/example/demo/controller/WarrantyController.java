package com.example.demo.controller;

import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warranties")
@Tag(name = "Warranties")
public class WarrantyController {

    private final WarrantyService warrantyService;

    public WarrantyController(WarrantyService warrantyService) {
        this.warrantyService = warrantyService;
    }

    @PostMapping("/register/{userId}/{productId}")
    @Operation(summary = "Register warranty")
    public Warranty register(@PathVariable Long userId,
                             @PathVariable Long productId,
                             @RequestBody Warranty w) {
        return warrantyService.registerWarranty(userId, productId, w);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get warranty")
    public Warranty get(@PathVariable Long id) {
        return warrantyService.getWarranty(id);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get user warranties")
    public List<Warranty> byUser(@PathVariable Long userId) {
        return warrantyService.getUserWarranties(userId);
    }
}
