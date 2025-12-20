package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class AlertSchedule{
    @Id
    private Long id;
    private String warranty;
    private Long daysBeforeExpiry;
    private Boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setwarranty(String warranty) {
        this.warranty = warranty;
    }

    public Long getDaysBeforeExpiry() {
        return daysBeforeExpiry;
    }

    public void setDaysBeforeExpiry(Long daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
    }

    public Boolean GetEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public AlertSchedule(Long id, String warranty, Long daysBeforeExpiry, Boolean enabled){
        this.id=id;
        this.warranty=warranty;
        this.daysBeforeExpiry=daysBeforeExpiry;
        this.enabled=enabled;
    }
    public AlertSchedule(){
        
    }
}