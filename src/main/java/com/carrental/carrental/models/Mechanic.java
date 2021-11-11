package com.carrental.carrental.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Mechanic {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Boolean onRepair;
    private String[] certifications;

    public Mechanic(String name, boolean onRepair, String[] certifications) {
        this.name = name;
        this.onRepair = onRepair;
        this.certifications = certifications;
    }

    public Mechanic() {
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

    public Boolean isOnRepair() {
        return onRepair;
    }

    public void setOnRepair(boolean onRepair) {
        this.onRepair = onRepair;
    }

    public String[] getCertifications() {
        return certifications;
    }

    public void setCertifications(String[] certifications) {
        this.certifications = certifications;
    }
}
