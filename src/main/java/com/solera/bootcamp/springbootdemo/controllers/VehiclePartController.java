package com.solera.bootcamp.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.solera.bootcamp.springbootdemo.models.VehiclePart;
import com.solera.bootcamp.springbootdemo.services.VehiclePartService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle-parts")
public class VehiclePartController {

    @Autowired
    private VehiclePartService vehiclePartService;

    @GetMapping
    public ResponseEntity<List<VehiclePart>> getAllVehicleParts() {
        List<VehiclePart> vehicleParts = vehiclePartService.getAllVehicleParts();
        return ResponseEntity.ok(vehicleParts);
    }

    @GetMapping("/{vehicleId}/{partId}")
    public ResponseEntity<VehiclePart> getVehiclePartById(@PathVariable Long vehicleId, @PathVariable Long partId) {
        VehiclePart vehiclePart = vehiclePartService.getVehiclePartById(vehicleId, partId);
        if (vehiclePart != null) {
            return ResponseEntity.ok(vehiclePart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<VehiclePart> createVehiclePart(@RequestBody VehiclePart vehiclePart) {
        VehiclePart savedVehiclePart = vehiclePartService.createVehiclePart(vehiclePart);
        return ResponseEntity.ok(savedVehiclePart);
    }

    @PutMapping("/{vehicleId}/{partId}")
    public ResponseEntity<VehiclePart> updateVehiclePart(@PathVariable Long vehicleId, @PathVariable Long partId, @RequestBody VehiclePart vehiclePartDetails) {
        VehiclePart updatedVehiclePart = vehiclePartService.updateVehiclePart(vehicleId, partId, vehiclePartDetails);
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
