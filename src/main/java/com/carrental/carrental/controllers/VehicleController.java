package com.carrental.carrental.controllers;

import com.carrental.carrental.models.Vehicle;
import com.carrental.carrental.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    VehicleRepository repository;

    @GetMapping
    public @ResponseBody ResponseEntity<List<Vehicle>> getAll() {
        return new ResponseEntity<>(new ArrayList<>(repository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Vehicle> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), HttpStatus.OK);
    }

    @GetMapping("/make/{make}")
    public @ResponseBody ResponseEntity<List<Vehicle>> getAllByMake(@PathVariable String make) {
        return new ResponseEntity<>(repository.findAllByMake(make, Sort.by("model")), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Vehicle> postVehicle(@RequestBody Vehicle newVehicle) {
        return new ResponseEntity<>(repository.save(newVehicle), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Vehicle> updateVehicleById(@PathVariable Long id, @RequestBody Vehicle update) {
        Vehicle vehicle = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (update.getStore() != null) {
            vehicle.setStore(update.getStore());
        }
        if (update.getMake() != null) {
            vehicle.setMake(update.getMake());
        }
        if (update.getModel() != null) {
            vehicle.setModel(update.getModel());
        }
        if (update.getYear() != null) {
            vehicle.setYear(update.getYear());
        }
        if (update.getMiles() != null) {
            vehicle.setMiles(update.getMiles());
        }

        return new ResponseEntity<>(repository.save(vehicle), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteVehicleById(@PathVariable Long id) {
        repository.deleteById(id);

        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
