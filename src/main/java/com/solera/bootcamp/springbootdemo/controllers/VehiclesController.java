package com.solera.bootcamp.springbootdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.bootcamp.springbootdemo.models.Workshop;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehiclesController {

     @GetMapping("/{id}")    
    public String getVehicleById(@PathVariable Long id) {
        return new String();
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>();
    }


    @PostMapping
    public String createVehicle(@RequestBody Vehicle vehicle) {
        return "Vehicle created successfully";
    }

    @PutMapping("/{id}")
    public String updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return "Vehicle with ID: " + id + " updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        return "Vehicle with ID: " + id + " deleted successfully";
    }




}
