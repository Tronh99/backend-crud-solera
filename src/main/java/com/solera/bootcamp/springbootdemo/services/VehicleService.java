package com.solera.bootcamp.springbootdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.bootcamp.springbootdemo.Repository.VehiclesRepository;
import com.solera.bootcamp.springbootdemo.models.Vehicle;
import com.solera.bootcamp.springbootdemo.models.VehicleWithCostDTO;

@Service
public class VehicleService {

    @Autowired
    private VehiclesRepository vehiclesRepository;

    public List<Vehicle> getAllVehicles() {
        return (List<Vehicle>) vehiclesRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehiclesRepository.findById(id).orElse(null);
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehiclesRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        if (vehiclesRepository.existsById(id)) {
            vehicle.setVehicleId(id);
            return vehiclesRepository.save(vehicle);
        }
        return null;
    }

    public void deleteVehicle(Long id) {
        vehiclesRepository.deleteById(id);
    }

    public VehicleWithCostDTO getVehicleWithCost(Long vehicleId) {
        Vehicle vehicle = vehiclesRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Double totalCost = vehiclesRepository.getTotalCostByVehicle(vehicleId);
        if (totalCost == null)
            totalCost = 0.0;

        return new VehicleWithCostDTO(
                vehicle.getVehicleId(),
                vehicle.getModel(),
                vehicle.getBrand(),
                vehicle.getYear(),
                vehicle.getColor(),
                vehicle.getVin(),
                totalCost.doubleValue()
        );
    }

}
