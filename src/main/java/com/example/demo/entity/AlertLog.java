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

    public String getwarranty() {
        return warranty;
    }

    public void setwarranty(String warranty) {
        this.warranty = warranty;
    }

    public Long getdaysBeforeExpiry() {
        return daysBeforeExpiry;
    }

    public Long setdaysBeforeExpiry(Long daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
    }

    public Boolean enabled() {
        return enabled;
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