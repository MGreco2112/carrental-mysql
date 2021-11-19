package com.carrental.carrental.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Store {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String streetAddress;


    @OneToMany
    @JoinColumn(name="vehicle_id", referencedColumnName = "id")
    public List<Vehicle> vehicles;

    @JsonIgnoreProperties("stores")
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "customer_store",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name="customer_id")
    )
    public Set<Customer> customers;

    public Store() {

    }

    public Store(Set<Customer> customers, List<Vehicle> vehicles , String name, String streetAddress) {
        this.customers = customers;
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

//    public void setVehicles(List<Vehicle> vehicles) {
//        this.vehicles = vehicles;
//    }
}
