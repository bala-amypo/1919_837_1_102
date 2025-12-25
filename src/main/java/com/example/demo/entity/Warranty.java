package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "warranties")
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private LocalDate purchaseDate;

    private LocalDate expiryDate;

    @Column(unique = true)
    private String serialNumber;

    // ✅ REQUIRED constructor for tests
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
}
