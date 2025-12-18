package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class AlertSchedule{
    @Id
    private Long id;
    private String warranty;
    private LocalDateTime sentAt;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getwarranty() {
        return warranty;
    }

    public void setwarranty(String warranty) {
        this.warranty = warranty;
    }

    public LocalDateTime sentAt() {
        return sentAt;
    }

    public Long setsentAt(LocalDateTime setAt) {
        this.sentAt = sentAt;
    }

    public String message() {
        return message;
    }

    public void setenabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Product(Long id, String warranty, Long daysBeforeExpiry, Boolean enabled){
        this.id=id;
        this.warranty=warranty;
        this.daysBeforeExpiry=daysBeforeExpiry;
        this.enabled=enabled;
    }
    public AlertSchedule(){
        
    }
}