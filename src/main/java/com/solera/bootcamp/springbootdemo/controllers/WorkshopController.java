package com.solera.bootcamp.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.solera.bootcamp.springbootdemo.dto.WorkshopDTO;
import com.solera.bootcamp.springbootdemo.services.WorkshopService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/workshops")
public class WorkshopController {

    @Autowired
    private WorkshopService workshopService;

    @GetMapping
    public ResponseEntity<List<WorkshopDTO>> getAllWorkshops() {
        List<WorkshopDTO> workshops = workshopService.getAllWorkshopsDTO();
        return ResponseEntity.ok(workshops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkshopDTO> getWorkshopById(@PathVariable Long id) {
        WorkshopDTO workshop = workshopService.getWorkshopDTOById(id);
        if (workshop != null) {
            return ResponseEntity.ok(workshop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<WorkshopDTO> createWorkshop(@Valid @RequestBody WorkshopDTO workshopDTO) {
        WorkshopDTO savedWorkshop = workshopService.createWorkshopFromDTO(workshopDTO);
        if (savedWorkshop != null) {
            return ResponseEntity.ok(savedWorkshop);
        } else {
            return ResponseEntity.badRequest().build(); // Location not found
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkshopDTO> updateWorkshop(@PathVariable Long id, @Valid @RequestBody WorkshopDTO workshopDTO) {
        WorkshopDTO updatedWorkshop = workshopService.updateWorkshopFromDTO(id, workshopDTO);
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
