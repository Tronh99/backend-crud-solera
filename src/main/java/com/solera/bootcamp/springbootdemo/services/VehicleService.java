package com.solera.bootcamp.springbootdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.bootcamp.springbootdemo.Repository.VehiclesRepository;
import com.solera.bootcamp.springbootdemo.models.Vehicle;

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

}
