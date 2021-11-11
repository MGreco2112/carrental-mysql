package com.carrental.carrental.controllers;

import com.carrental.carrental.models.Mechanic;
import com.carrental.carrental.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/mechanics")
public class MechanicController {

    @Autowired
    MechanicRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<Mechanic>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mechanic> getById(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), HttpStatus.OK);
    }

    @GetMapping("/repairs/{onRepair}")
    public ResponseEntity<Iterable<Mechanic>> getAllOnRepair(@PathVariable Boolean onRepair) {
        return new ResponseEntity<>(repository.getAllByOnRepair(onRepair, Sort.by("name")), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mechanic> createOne(@RequestBody Mechanic mechanic) {
        return new ResponseEntity<>(repository.save(mechanic), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mechanic> modifyOneById(@PathVariable Long id, @RequestBody Mechanic update) {
        Mechanic oldMechanic = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (update.getName() != null) {
            oldMechanic.setName(update.getName());
        }
        if (update.isOnRepair() != null) {
            oldMechanic.setOnRepair(update.isOnRepair());
        }
        if (update.getCertifications() != null) {
            oldMechanic.setCertifications(update.getCertifications());
        }

        return new ResponseEntity<>(repository.save(oldMechanic), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
