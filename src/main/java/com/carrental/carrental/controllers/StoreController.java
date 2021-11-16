package com.carrental.carrental.controllers;

import com.carrental.carrental.models.Store;
import com.carrental.carrental.models.Vehicle;
import com.carrental.carrental.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Store>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getOneById(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        return new ResponseEntity<>(repository.save(store), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable Long id, @RequestBody Store update) {
        Store selectedStore = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (update.customers != null) {
            selectedStore.customers.addAll(update.customers);
        }
        if (update.getVehicles() != null) {

            for (Vehicle vehicleId: update.getVehicles()) {

                if (!selectedStore.getVehicles().contains(vehicleId)) {
                    selectedStore.getVehicles().add(vehicleId);
                }
            }
        }
        if (update.getName() != null) {
            selectedStore.setName(update.getName());
        }
        if (update.getStreetAddress() != null) {
            selectedStore.setStreetAddress(update.getStreetAddress());
        }
        if (update.getVehicles() != null) {
            selectedStore.setVehicles(update.getVehicles());
        }

        return new ResponseEntity<>(repository.save(selectedStore), HttpStatus.ACCEPTED);
    }


}
