package com.solera.bootcamp.springbootdemo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.bootcamp.springbootdemo.Repository.VehiclesRepository;
import com.solera.bootcamp.springbootdemo.models.Vehicle;
import com.solera.bootcamp.springbootdemo.models.VehicleWithCostDTO;
import com.solera.bootcamp.springbootdemo.models.Workshop;
import com.solera.bootcamp.springbootdemo.dto.VehicleDTO;

@Service
public class VehicleService {

    @Autowired
    private VehiclesRepository vehiclesRepository;

    @Autowired
    private WorkshopService workshopService;

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

    // DTO Methods
    public List<VehicleDTO> getAllVehiclesDTO() {
        return getAllVehicles().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public VehicleDTO getVehicleDTOById(Long id) {
        Vehicle vehicle = getVehicleById(id);
        return vehicle != null ? convertToDTO(vehicle) : null;
    }

    public VehicleDTO createVehicleFromDTO(VehicleDTO vehicleDTO) {
        Vehicle vehicle = convertToEntity(vehicleDTO);
        if (vehicle != null) {
            Vehicle savedVehicle = createVehicle(vehicle);
            return convertToDTO(savedVehicle);
        }
        return null;
    }

    public VehicleDTO updateVehicleFromDTO(Long id, VehicleDTO vehicleDTO) {
        if (vehiclesRepository.existsById(id)) {
            Vehicle vehicle = convertToEntity(vehicleDTO);
            if (vehicle != null) {
                Vehicle updatedVehicle = updateVehicle(id, vehicle);
                return updatedVehicle != null ? convertToDTO(updatedVehicle) : null;
            }
        }
        return null;
    }

    // Helper methods for DTO conversion
    private VehicleDTO convertToDTO(Vehicle vehicle) {
        VehicleDTO dto = new VehicleDTO();
        dto.setVehicleId(vehicle.getVehicleId());
        dto.setModel(vehicle.getModel());
        dto.setBrand(vehicle.getBrand());
        dto.setYear(vehicle.getYear());
        dto.setColor(vehicle.getColor());
        dto.setVin(vehicle.getVin());
        dto.setWorkshopId(vehicle.getWorkshop() != null ? vehicle.getWorkshop().getWorkshopId() : null);
        return dto;
    }

    private Vehicle convertToEntity(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(dto.getVehicleId());
        vehicle.setModel(dto.getModel());
        vehicle.setBrand(dto.getBrand());
        vehicle.setYear(dto.getYear());
        vehicle.setColor(dto.getColor());
        vehicle.setVin(dto.getVin());

        // Fetch the workshop by ID if provided
        if (dto.getWorkshopId() != null) {
            Workshop workshop = workshopService.getWorkshopById(dto.getWorkshopId());
            if (workshop == null) {
                return null; // Workshop not found
            }
            vehicle.setWorkshop(workshop);
        }

        return vehicle;
    }

    // Cost calculation method that was missing after merge
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
                totalCost.doubleValue());
    }

}
