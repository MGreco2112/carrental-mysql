package com.carrental.carrental.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicle {
    private @Id @GeneratedValue Long id;
    private String make;
    private String model;
    private String year;
    private Integer miles;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
     Store stores;

    //Create Vehicle to Location Relationship, One to One

    public Vehicle() {

    }

    public Vehicle(Store stores , String make, String model, String year, Integer miles) {
        this.stores = stores;
        this.make = make;
        this.model = model;
        this.year = year;
        this.miles = miles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

}
