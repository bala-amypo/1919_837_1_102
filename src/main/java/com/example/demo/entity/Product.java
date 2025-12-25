package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "products")
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

    public Product() {}

    // REQUIRED by tests
    public Product(Long id, String name, String brand, String modelNumber,
                   String category, String serialNumber) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.category = category;
        this.serialNumber = serialNumber;
    }

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModelNumber() { return modelNumber; }
    public void setModelNumber(String modelNumber) { this.modelNumber = modelNumber; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public List<Warranty> getWarranties() { return warranties; }
    public void setWarranties(List<Warranty> warranties) { this.warranties = warranties; }
}
