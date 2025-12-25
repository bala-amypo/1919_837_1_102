package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "alert_schedules")
public class AlertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 FIX: Integer instead of int
    private Integer daysBeforeExpiry;

    @ManyToOne
    @JoinColumn(name = "warranty_id")
    private Warranty warranty;

    public AlertSchedule() {}

    public AlertSchedule(Long id, Integer daysBeforeExpiry, Warranty warranty) {
        this.id = id;
        this.daysBeforeExpiry = daysBeforeExpiry;
        this.warranty = warranty;
    }

    public Long getId() {
        return id;
    }

    public Integer getDaysBeforeExpiry() {
        return daysBeforeExpiry;
    }

    public void setDaysBeforeExpiry(Integer daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }
}
