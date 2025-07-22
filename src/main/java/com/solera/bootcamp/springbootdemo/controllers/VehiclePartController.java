package com.solera.bootcamp.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.solera.bootcamp.springbootdemo.models.VehiclePart;
import com.solera.bootcamp.springbootdemo.models.VehiclePartId;
import com.solera.bootcamp.springbootdemo.Repository.VehiclePartRepository;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vehicle-parts")
public class VehiclePartController {

    @Autowired
    private VehiclePartRepository vehiclePartRepository;

    @GetMapping
    public ResponseEntity<Iterable<VehiclePart>> getAllVehicleParts() {
        Iterable<VehiclePart> vehicleParts = vehiclePartRepository.findAll();
        return ResponseEntity.ok(vehicleParts);
    }

    @GetMapping("/{vehicleId}/{partId}")
    public ResponseEntity<VehiclePart> getVehiclePartById(@PathVariable Long vehicleId, @PathVariable Long partId) {
        VehiclePartId id = new VehiclePartId(vehicleId, partId);
        Optional<VehiclePart> vehiclePart = vehiclePartRepository.findById(id);
        if (vehiclePart.isPresent()) {
            return ResponseEntity.ok(vehiclePart.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<VehiclePart> createVehiclePart(@RequestBody VehiclePart vehiclePart) {
        VehiclePart savedVehiclePart = vehiclePartRepository.save(vehiclePart);
        return ResponseEntity.ok(savedVehiclePart);
    }

    @PutMapping("/{vehicleId}/{partId}")
    public ResponseEntity<VehiclePart> updateVehiclePart(@PathVariable Long vehicleId, @PathVariable Long partId, @RequestBody VehiclePart vehiclePartDetails) {
        VehiclePartId id = new VehiclePartId(vehicleId, partId);
        Optional<VehiclePart> optionalVehiclePart = vehiclePartRepository.findById(id);
        if (optionalVehiclePart.isPresent()) {
            VehiclePart vehiclePart = optionalVehiclePart.get();
            vehiclePart.setQuantity(vehiclePartDetails.getQuantity());
            vehiclePart.setVehicle(vehiclePartDetails.getVehicle());
            vehiclePart.setPart(vehiclePartDetails.getPart());
            VehiclePart updatedVehiclePart = vehiclePartRepository.save(vehiclePart);
            return ResponseEntity.ok(updatedVehiclePart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{vehicleId}/{partId}")
    public ResponseEntity<Void> deleteVehiclePart(@PathVariable Long vehicleId, @PathVariable Long partId) {
        VehiclePartId id = new VehiclePartId(vehicleId, partId);
        if (vehiclePartRepository.existsById(id)) {
            vehiclePartRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
