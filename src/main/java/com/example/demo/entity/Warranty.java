package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate purchaseDate;

    @Column(name = "end_date")
    private LocalDate expiryDate;

    @Column(unique = true)
    private String serialNumber;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;
}
