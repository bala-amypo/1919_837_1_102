package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alert_schedules")
@Getter
@Setter
@NoArgsConstructor
@Builder
public class AlertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long daysBeforeExpiry;

    private Boolean enabled;

    @ManyToOne
    @JoinColumn(name = "warranty_id", nullable = false)
    private Warranty warranty;

    // ✅ Required constructor for tests
    public AlertSchedule(Long id, Long daysBeforeExpiry, Boolean enabled, Warranty warranty) {
        this.id = id;
        this.daysBeforeExpiry = daysBeforeExpiry;
        this.enabled = enabled;
        this.warranty = warranty;
    }

    public int getDaysBeforeExpiry() {
    return daysBeforeExpiry;
}

public void setWarranty(Warranty warranty) {
    this.warranty = warranty;
}
}
