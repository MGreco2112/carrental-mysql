package com.carrental.carrental.controllers;

import com.carrental.carrental.models.Vehicle;
import com.carrental.carrental.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


}
