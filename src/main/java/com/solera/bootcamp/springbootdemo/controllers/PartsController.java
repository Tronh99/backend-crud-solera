package com.solera.bootcamp.springbootdemo.controllers;

import com.solera.bootcamp.springbootdemo.models.Part;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.bootcamp.springbootdemo.models.Workshop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.solera.bootcamp.springbootdemo.models.Part;
import com.solera.bootcamp.springbootdemo.Repository.PartRepository;
import java.util.Optional;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/parts")
public class PartsController {

     @GetMapping("/{id}")    
    public String getPartById(@PathVariable Long id) {
        return "";
    }
    @Autowired
    private PartRepository partRepository;

    @GetMapping
    public ResponseEntity<Iterable<Part>> getAllParts() {
        Iterable<Part> parts = partRepository.findAll();
        return ResponseEntity.ok(parts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Part> getPartById(@PathVariable Long id) {
        Optional<Part> part = partRepository.findById(id);
        if (part.isPresent()) {
            return ResponseEntity.ok(part.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Part> createPart(@RequestBody Part part) {
        Part savedPart = partRepository.save(part);
        return ResponseEntity.ok(savedPart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Part> updatePart(@PathVariable Long id, @RequestBody Part partDetails) {
        Optional<Part> optionalPart = partRepository.findById(id);
        if (optionalPart.isPresent()) {
            Part part = optionalPart.get();
            part.setName(partDetails.getName());
            part.setDescription(partDetails.getDescription());
            part.setQuantity(partDetails.getQuantity());
            part.setCost(partDetails.getCost());
            Part updatedPart = partRepository.save(part);
            return ResponseEntity.ok(updatedPart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePart(@PathVariable Long id) {
        if (partRepository.existsById(id)) {
            partRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
