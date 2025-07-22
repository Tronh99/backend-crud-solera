package com.solera.bootcamp.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.solera.bootcamp.springbootdemo.models.Workshop;
import com.solera.bootcamp.springbootdemo.services.WorkshopService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/workshops")
public class WorkshopController {

    @Autowired
    private WorkshopService workshopService;

    @GetMapping
    public ResponseEntity<List<Workshop>> getAllWorkshops() {
        List<Workshop> workshops = workshopService.getAllWorkshops();
        return ResponseEntity.ok(workshops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workshop> getWorkshopById(@PathVariable Long id) {
        Workshop workshop = workshopService.getWorkshopById(id);
        if (workshop != null) {
            return ResponseEntity.ok(workshop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Workshop> createWorkshop(@Valid @RequestBody Workshop workshop) {
        Workshop savedWorkshop = workshopService.createWorkshop(workshop);
        return ResponseEntity.ok(savedWorkshop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workshop> updateWorkshop(@PathVariable Long id, @Valid @RequestBody Workshop workshopDetails) {
        Workshop updatedWorkshop = workshopService.updateWorkshop(id, workshopDetails);
        if (updatedWorkshop != null) {
            return ResponseEntity.ok(updatedWorkshop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkshop(@PathVariable Long id) {
        boolean deleted = workshopService.deleteWorkshop(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
