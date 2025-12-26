package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "products")
@Data
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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Warranty> warranties;

    // REQUIRED BY TEST CASES
    public Product(Long id, String name, String brand, String modelNumber, String category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.category = category;
    }
}
