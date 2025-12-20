package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import jakarta.persistence.Table;

@Entity
@Table(name="visak")
public class AlertLog{
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

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public AlertLog(Long id, String warranty, LocalDateTime sentAt, String message){
        this.id=id;
        this.warranty=warranty;
        this.sentAt=sentAt;
        this.message=message;
    }
    public AlertLog(){ 
    }
}