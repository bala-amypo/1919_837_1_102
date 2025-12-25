package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private LocalDate purchaseDate;
    private LocalDate expiryDate;
    private String serialNumber;

    public Warranty() {}

    public Warranty(Long id, User user, Product product,
                    LocalDate purchaseDate, LocalDate expiryDate,
                    String serialNumber) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.purchaseDate = purchaseDate;
        this.expiryDate = expiryDate;
        this.serialNumber = serialNumber;
    }

    public Long getId() { return id; }
    public User getUser() { return user; }
    public Product getProduct() { return product; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getSerialNumber() { return serialNumber; }

    public void setUser(User user) { this.user = user; }
    public void setProduct(Product product) { this.product = product; }
}
