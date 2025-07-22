package com.solera.bootcamp.springbootdemo.controllers;

import com.solera.bootcamp.springbootdemo.models.Workshop;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.solera.bootcamp.springbootdemo.models.Workshop;
import com.solera.bootcamp.springbootdemo.Repository.WorkshopRepository;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/workshops")
public class WorkshopController {

    @Autowired
    private WorkshopRepository workshopRepository;

    @GetMapping
    public ResponseEntity<Iterable<Workshop>> getAllWorkshops() {
        Iterable<Workshop> workshops = workshopRepository.findAll();
        return ResponseEntity.ok(workshops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workshop> getWorkshopById(@PathVariable Long id) {
        Optional<Workshop> workshop = workshopRepository.findById(id);
        if (workshop.isPresent()) {
            return ResponseEntity.ok(workshop.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Workshop> createWorkshop(@RequestBody Workshop workshop) {
        Workshop savedWorkshop = workshopRepository.save(workshop);
        return ResponseEntity.ok(savedWorkshop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workshop> updateWorkshop(@PathVariable Long id, @RequestBody Workshop workshopDetails) {
        Optional<Workshop> optionalWorkshop = workshopRepository.findById(id);
        if (optionalWorkshop.isPresent()) {
            Workshop workshop = optionalWorkshop.get();
            workshop.setName(workshopDetails.getName());
            workshop.setDescription(workshopDetails.getDescription());
            workshop.setLocation(workshopDetails.getLocation());
            Workshop updatedWorkshop = workshopRepository.save(workshop);
            return ResponseEntity.ok(updatedWorkshop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkshop(@PathVariable Long id) {
        if (workshopRepository.existsById(id)) {
            workshopRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
