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
        this.brand = daysBeforeExpiry;
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