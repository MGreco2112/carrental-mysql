package com.carrental.carrental.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Repair {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name="vehicle_id", referencedColumnName = "id")
    private Vehicle repairVehicle;

    @OneToMany
    @JoinColumn(name="mechanic_id", referencedColumnName = "id")
    private List<Mechanic> mechanics;

    private boolean isComplete;

    public Repair(Vehicle repairVehicle, List<Mechanic> mechanics, boolean isComplete) {
        this.repairVehicle = repairVehicle;
        this.mechanics = mechanics;
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

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(List<Mechanic> mechanic) {
        this.mechanics = mechanic;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
