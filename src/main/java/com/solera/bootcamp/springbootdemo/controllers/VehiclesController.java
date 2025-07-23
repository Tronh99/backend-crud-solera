package com.solera.bootcamp.springbootdemo.controllers;

import java.util.List;
import com.solera.bootcamp.springbootdemo.models.Vehicle;
import com.solera.bootcamp.springbootdemo.models.VehicleWithCostDTO;
import com.solera.bootcamp.springbootdemo.dto.VehicleDTO;
import com.solera.bootcamp.springbootdemo.services.VehicleService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehiclesController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        List<VehicleDTO> vehicles = vehicleService.getAllVehiclesDTO();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id) {
        VehicleDTO vehicle = vehicleService.getVehicleDTOById(id);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/with-cost")
    public ResponseEntity<VehicleWithCostDTO> getVehicleWithCost(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleWithCost(id));
    }

    @GetMapping("/with-cost")
    public ResponseEntity<List<VehicleWithCostDTO>> getAllVehiclesWithCost() {
        List<VehicleWithCostDTO> vehicles = vehicleService.getAllVehiclesWithCost();
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO savedVehicle = vehicleService.createVehicleFromDTO(vehicleDTO);
        if (savedVehicle != null) {
            return ResponseEntity.ok(savedVehicle);
        } else {
            return ResponseEntity.badRequest().build(); // Workshop not found
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable Long id, @Valid @RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO updatedVehicle = vehicleService.updateVehicleFromDTO(id, vehicleDTO);
        if (updatedVehicle != null) {
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle != null) {
            vehicleService.deleteVehicle(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}