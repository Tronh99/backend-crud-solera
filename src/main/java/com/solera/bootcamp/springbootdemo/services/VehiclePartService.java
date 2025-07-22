package com.solera.bootcamp.springbootdemo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solera.bootcamp.springbootdemo.Repository.VehiclePartRepository;
import com.solera.bootcamp.springbootdemo.models.VehiclePart;
import com.solera.bootcamp.springbootdemo.models.VehiclePartId;

@Service
public class VehiclePartService {

    @Autowired
    private VehiclePartRepository vehiclePartRepository;

    public List<VehiclePart> getAllVehicleParts() {
        return (List<VehiclePart>) vehiclePartRepository.findAll();
    }

    public VehiclePart getVehiclePartById(VehiclePartId id) {
        return vehiclePartRepository.findById(id).orElse(null);
    }

    public VehiclePart getVehiclePartById(Long vehicleId, Long partId) {
        VehiclePartId id = new VehiclePartId(vehicleId, partId);
        return vehiclePartRepository.findById(id).orElse(null);
    }

    public VehiclePart createVehiclePart(VehiclePart vehiclePart) {
        return vehiclePartRepository.save(vehiclePart);
    }

    public VehiclePart updateVehiclePart(VehiclePartId id, VehiclePart vehiclePart) {
        if (vehiclePartRepository.existsById(id)) {
            vehiclePart.setId(id);
            return vehiclePartRepository.save(vehiclePart);
        }
        return null;
    }

    public VehiclePart updateVehiclePart(Long vehicleId, Long partId, VehiclePart vehiclePart) {
        VehiclePartId id = new VehiclePartId(vehicleId, partId);
        return updateVehiclePart(id, vehiclePart);
    }

    public boolean deleteVehiclePart(VehiclePartId id) {
        if (vehiclePartRepository.existsById(id)) {
            vehiclePartRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteVehiclePart(Long vehicleId, Long partId) {
        VehiclePartId id = new VehiclePartId(vehicleId, partId);
        return deleteVehiclePart(id);
    }

    public boolean existsById(VehiclePartId id) {
        return vehiclePartRepository.existsById(id);
    }

    public boolean existsById(Long vehicleId, Long partId) {
        VehiclePartId id = new VehiclePartId(vehicleId, partId);
        return vehiclePartRepository.existsById(id);
    }
}
