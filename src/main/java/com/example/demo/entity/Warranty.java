package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import jakarta.persistence.Column;

@Entity
public class Warranty{
    @Id
    private Long id;
    private String user;
    private String product;
    private LocalDate purchaseDate;
    private LocalDate expiryDate;
    @Column(unique=true)
    private String serialNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String user() {
        return user;
    }

    public void setuser(String user) {
        this.user = user;
    }

    public String product() {
        return product;
    }

    public void setproduct(String product) {
        this.product = product;
    }

    public LocalDate purchaseDate() {
        return purchaseDate;
    }

    public void setpurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate expiryDate() {
        return expiryDate;
    }

    public void setexpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getserialNumber() {
        return serialNumber;
    }

    public void setserialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Product(Long id, String user, String product, LocalDate purchaseDate, LocalDate expiryDate, String serialNumber){
        this.id=id;
        this.user = user;
        this.product = product;
        this.modelNumber=modelNumber;
        this.category=category;
    }
    public Product(){
        
    }
}