package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "warranties")
@Getter
@Setter
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
    private List<AlertSchedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "warranty", cascade = CascadeType.ALL)
    private List<AlertLog> logs = new ArrayList<>();
}
