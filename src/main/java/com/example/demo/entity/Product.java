package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String category;
    private String modelNumber;
    private String serialNumber;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Warranty> warranties = new ArrayList<>();

    // ✅ REQUIRED BY TEST CASES (DO NOT REMOVE)
    public Product(Long id,
                   String name,
                   String brand,
                   String category,
                   String modelNumber,
                   String serialNumber) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.modelNumber = modelNumber;
        this.serialNumber = serialNumber;
    }
}
