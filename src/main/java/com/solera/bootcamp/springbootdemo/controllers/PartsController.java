package com.solera.bootcamp.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.solera.bootcamp.springbootdemo.models.Part;
import com.solera.bootcamp.springbootdemo.services.PartService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/parts")
public class PartsController {

    @Autowired
    private PartService partService;

    @GetMapping
    public ResponseEntity<List<Part>> getAllParts() {
        List<Part> parts = partService.getAllParts();
        return ResponseEntity.ok(parts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Part> getPartById(@PathVariable Long id) {
        Part part = partService.getPartById(id);
        if (part != null) {
            return ResponseEntity.ok(part);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Part> createPart(@RequestBody Part part) {
        Part savedPart = partService.createPart(part);
        return ResponseEntity.ok(savedPart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Part> updatePart(@PathVariable Long id, @RequestBody Part partDetails) {
        Part updatedPart = partService.updatePart(id, partDetails);
        if (updatedPart != null) {
            return ResponseEntity.ok(updatedPart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePart(@PathVariable Long id) {
        boolean deleted = partService.deletePart(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}