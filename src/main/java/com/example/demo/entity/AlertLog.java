package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
@Entity
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

    public void setmessage(String message) {
        this.message = message;
    }

    public Product(Long id, String warranty, LocalDateTime sentAt, String message){
        this.id=id;
        this.warranty=warranty;
        this.sentAt=sentAt;
        this.message=message;
    }
    public AlertLog(){
        
    }
}