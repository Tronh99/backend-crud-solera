package com.solera.bootcamp.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.solera.bootcamp.springbootdemo.dto.VehiclePartDTO;
import com.solera.bootcamp.springbootdemo.services.VehiclePartService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle-parts")
public class VehiclePartController {

    @Autowired
    private VehiclePartService vehiclePartService;

    @GetMapping
    public ResponseEntity<List<VehiclePartDTO>> getAllVehicleParts() {
        List<VehiclePartDTO> vehicleParts = vehiclePartService.getAllVehiclePartsDTO();
        return ResponseEntity.ok(vehicleParts);
    }

    @GetMapping("/{vehicleId}/{partId}")
    public ResponseEntity<VehiclePartDTO> getVehiclePartById(@PathVariable Long vehicleId, @PathVariable Long partId) {
        VehiclePartDTO vehiclePart = vehiclePartService.getVehiclePartDTOById(vehicleId, partId);
        if (vehiclePart != null) {
            return ResponseEntity.ok(vehiclePart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<VehiclePartDTO> createVehiclePart(@Valid @RequestBody VehiclePartDTO vehiclePartDTO) {
        VehiclePartDTO savedVehiclePart = vehiclePartService.createVehiclePartFromDTO(vehiclePartDTO);
        if (savedVehiclePart != null) {
            return ResponseEntity.ok(savedVehiclePart);
        } else {
            return ResponseEntity.badRequest().build(); // Vehicle or Part not found
        }
    }

    @PutMapping("/{vehicleId}/{partId}")
    public ResponseEntity<VehiclePartDTO> updateVehiclePart(@PathVariable Long vehicleId, @PathVariable Long partId, @Valid @RequestBody VehiclePartDTO vehiclePartDTO) {
        VehiclePartDTO updatedVehiclePart = vehiclePartService.updateVehiclePartFromDTO(vehicleId, partId, vehiclePartDTO);
        if (updatedVehiclePart != null) {
            return ResponseEntity.ok(updatedVehiclePart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{vehicleId}/{partId}")
    public ResponseEntity<Void> deleteVehiclePart(@PathVariable Long vehicleId, @PathVariable Long partId) {
        boolean deleted = vehiclePartService.deleteVehiclePart(vehicleId, partId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
