package com.carrental.carrental.models;

import javax.persistence.*;

@Entity
public class Repair {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Vehicle repairVehicle;
    @OneToMany
    private Mechanic mechanic;
    private boolean isComplete;

    public Repair(Vehicle repairVehicle, Mechanic mechanic, boolean isComplete) {
        this.repairVehicle = repairVehicle;
        this.mechanic = mechanic;
        this.isComplete = isComplete;
    }

    public Repair() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getRepairVehicle() {
        return repairVehicle;
    }

    public void setRepairVehicle(Vehicle repairVehicle) {
        this.repairVehicle = repairVehicle;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
