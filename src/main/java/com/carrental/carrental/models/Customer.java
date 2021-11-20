package com.carrental.carrental.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    private @Id @GeneratedValue Long id;
    private String name;
    private Boolean isMember;
    private String licenseNumber;

    @JsonIgnoreProperties("customers")
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "customer_store",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name="store_id")
    )
    private Set<Store> stores;

    public Customer() {

    }

    public Customer(Set<Store> stores, String name, Boolean isMember, String licenseNumber) {
        this.stores = stores;
        this.name = name;
        this.isMember = isMember;
        this.licenseNumber = licenseNumber;
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

    public Boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(Boolean member) {
        isMember = member;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }
}
