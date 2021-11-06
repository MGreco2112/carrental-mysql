package com.carrental.carrental.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
    private @Id @GeneratedValue Long id;
    private String name;
    private Boolean isMember;
    private String licenseNumber;

    public Customer() {

    }

    public Customer(String name, Boolean isMember, String licenseNumber) {
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
}
