package com.carrental.carrental.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Store {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String streetAddress;

    @OneToMany
    @JoinColumn(name="vehicle_id", referencedColumnName = "id")
    private List<Vehicle> vehicles;

    public Store() {

    }

    public Store(List<Vehicle> vehicles , String name, String streetAddress) {
        this.vehicles = vehicles;
        this.name = name;
        this.streetAddress = streetAddress;
    }

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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
