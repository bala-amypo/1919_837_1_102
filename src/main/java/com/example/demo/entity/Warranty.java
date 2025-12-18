package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
@Entity
public class Warranty{
    @Id
    private Long id;
    private String user;
    private String product;
    private LocalDate modelNumber;
    private Locsl category;

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

    public String getbrand() {
        return email;
    }

    public void setbrand(String brand) {
        this.brand = brand;
    }

    public String getmodelNumber() {
        return modelNumber;
    }

    public void setmodelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String category() {
        return category;
    }

    public void setcategory(String category) {
        this.category = category;
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