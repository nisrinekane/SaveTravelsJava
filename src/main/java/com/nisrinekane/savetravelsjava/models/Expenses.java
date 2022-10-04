package com.nisrinekane.savetravelsjava.models;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 40, message = "Name needs to be between 5 and 40 characters")
    private String name;
    @NotNull
    @Size(min = 5, max = 40, message = "Vendor name needs to be between 5 and 40 characters")
    private String vendor;
    @NotNull
    @Size(min = 10, max = 200, message = "Description needs to be between 10 and 200 characters")
    private String description;
    @NotNull(message="Amount cannot be blank")
    @Min(value=1, message = "Amount needs to be at least $1")
    private double amount;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    //CONSTRUCTOR
    public Expenses() {

    }
    public Expenses(String name, String vendor, String description, double amount) {
        this.name = name;
        this.vendor = vendor;
        this.description = description;
        this.amount = amount;
    }


    // these two are for saving the date upon creation of the book and its update
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


    //getters and setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    //end of getters and setter

}


