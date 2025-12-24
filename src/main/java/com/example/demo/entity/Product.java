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
    private String modelNumber;
    private String category;
    private String serialNumber;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Warranty> warranties = new ArrayList<>();

    // ✅ EXACT constructor expected by test cases (ORDER MATTERS)
    public Product(Long id,
                   String name,
                   String brand,
                   String modelNumber,
                   String category,
                   String serialNumber) {

        this.id = id;
        this.name = name;
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.category = category;
        this.serialNumber = serialNumber;
    }
}
