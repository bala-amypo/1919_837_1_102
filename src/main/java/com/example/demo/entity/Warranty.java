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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String user() {
        return user;
    }

    public void setuser(String user) {
        this.user = user;
    }

    public String product() {
        return modelNumber;
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

    public void setexpiryDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }


    public Product(Long id, String name, String brand, String modelNumber, String category){
        this.id=id;
        this.name=name;
        this.brand=brand;
        this.modelNumber=modelNumber;
        this.category=category;
    }
    public Product(){
        
    }
}