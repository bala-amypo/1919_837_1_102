package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alert_logs")
@Getter
@Setter
@NoArgsConstructor
@Builder
public class AlertLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "warranty_id", nullable = false)
    private Warranty warranty;

    private LocalDateTime sentAt;

    @Column(nullable = false)
    private String message;

    // ✅ Required constructor for tests
    public AlertLog(Long id, Warranty warranty, LocalDateTime sentAt, String message) {
        this.id = id;
        this.warranty = warranty;
        this.sentAt = sentAt;
        this.message = message;
    }

    @PrePersist
    public void prePersist() {
        if (this.sentAt == null) {
            this.sentAt = LocalDateTime.now();
        }
    }
}
