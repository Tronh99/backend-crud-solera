package com.solera.bootcamp.springbootdemo.controllers;

import java.util.List;
import com.solera.bootcamp.springbootdemo.models.Vehicle;
import com.solera.bootcamp.springbootdemo.dto.VehicleDTO;
import com.solera.bootcamp.springbootdemo.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehiclesController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = vehicleService.createVehicle(vehicle);
        return ResponseEntity.ok(savedVehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicle);
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

    // DTO Endpoints - These endpoints use DTOs and only require IDs for relationships
    @GetMapping("/dto")
    public ResponseEntity<List<VehicleDTO>> getAllVehiclesDTO() {
        List<VehicleDTO> vehicles = vehicleService.getAllVehiclesDTO();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<VehicleDTO> getVehicleDTOById(@PathVariable Long id) {
        VehicleDTO vehicle = vehicleService.getVehicleDTOById(id);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/dto")
    public ResponseEntity<VehicleDTO> createVehicleFromDTO(@Valid @RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO savedVehicle = vehicleService.createVehicleFromDTO(vehicleDTO);
        if (savedVehicle != null) {
            return ResponseEntity.ok(savedVehicle);
        } else {
            return ResponseEntity.badRequest().build(); // Workshop not found
        }
    }

    @PutMapping("/dto/{id}")
    public ResponseEntity<VehicleDTO> updateVehicleFromDTO(@PathVariable Long id, @Valid @RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO updatedVehicle = vehicleService.updateVehicleFromDTO(id, vehicleDTO);
        if (updatedVehicle != null) {
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}