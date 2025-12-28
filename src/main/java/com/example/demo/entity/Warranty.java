package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "warranties")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(unique = true)
    private String serialNumber;

    @OneToMany(mappedBy = "warranty", cascade = CascadeType.ALL)
    private List<AlertSchedule> schedules;

    @OneToMany(mappedBy = "warranty", cascade = CascadeType.ALL)
    private List<AlertLog> logs;
}
