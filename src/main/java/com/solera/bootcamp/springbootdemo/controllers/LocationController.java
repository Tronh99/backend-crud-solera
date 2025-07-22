package com.solera.bootcamp.springbootdemo.controllers;

import com.solera.bootcamp.springbootdemo.models.Location;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.bootcamp.springbootdemo.models.Workshop;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

 @GetMapping("/{id}")    
    public String getLocationById(@PathVariable Long id) {
        return new String();
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return new ArrayList<>();
    }


    @PostMapping
    public String createLocation(@RequestBody Location location) {
        return "Location created successfully";
    }

    @PutMapping("/{id}")
    public String updateLocation(@PathVariable Long id, @RequestBody Location location) {
        return "Location with ID: " + id + " updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteLocation(@PathVariable Long id) {
        return "Location with ID: " + id + " deleted successfully";
    }



}
