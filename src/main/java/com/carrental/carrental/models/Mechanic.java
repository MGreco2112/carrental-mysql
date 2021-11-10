package com.carrental.carrental.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Mechanic {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean onRepair;
    private List<String> certifications;

    public Mechanic(String name, boolean onRepair, List<String> certifications) {
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

    public boolean isOnRepair() {
        return onRepair;
    }

    public void setOnRepair(boolean onRepair) {
        this.onRepair = onRepair;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }
}
