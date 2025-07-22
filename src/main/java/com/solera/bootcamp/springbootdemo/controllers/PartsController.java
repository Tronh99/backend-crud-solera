package com.solera.bootcamp.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.solera.bootcamp.springbootdemo.dto.PartDTO;
import com.solera.bootcamp.springbootdemo.services.PartService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/parts")
public class PartsController {

    @Autowired
    private PartService partService;

    @GetMapping
    public ResponseEntity<List<PartDTO>> getAllParts() {
        List<PartDTO> parts = partService.getAllPartsDTO();
        return ResponseEntity.ok(parts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartDTO> getPartById(@PathVariable Long id) {
        PartDTO part = partService.getPartDTOById(id);
        if (part != null) {
            return ResponseEntity.ok(part);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PartDTO> createPart(@Valid @RequestBody PartDTO partDTO) {
        PartDTO savedPart = partService.createPartFromDTO(partDTO);
        return ResponseEntity.ok(savedPart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartDTO> updatePart(@PathVariable Long id, @Valid @RequestBody PartDTO partDTO) {
        PartDTO updatedPart = partService.updatePartFromDTO(id, partDTO);
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