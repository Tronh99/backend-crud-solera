package com.solera.bootcamp.springbootdemo.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solera.bootcamp.springbootdemo.Repository.VehiclePartRepository;
import com.solera.bootcamp.springbootdemo.models.VehiclePart;
import com.solera.bootcamp.springbootdemo.models.VehiclePartId;
import com.solera.bootcamp.springbootdemo.models.Vehicle;
import com.solera.bootcamp.springbootdemo.models.Part;
import com.solera.bootcamp.springbootdemo.dto.VehiclePartDTO;

@Service
public class VehiclePartService {

    @Autowired
    private VehiclePartRepository vehiclePartRepository;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private PartService partService;

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

    // DTO Methods
    public List<VehiclePartDTO> getAllVehiclePartsDTO() {
        return getAllVehicleParts().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public VehiclePartDTO getVehiclePartDTOById(Long vehicleId, Long partId) {
        VehiclePart vehiclePart = getVehiclePartById(vehicleId, partId);
        return vehiclePart != null ? convertToDTO(vehiclePart) : null;
    }

    public VehiclePartDTO createVehiclePartFromDTO(VehiclePartDTO vehiclePartDTO) {
        VehiclePart vehiclePart = convertToEntity(vehiclePartDTO);
        if (vehiclePart != null) {
            VehiclePart savedVehiclePart = createVehiclePart(vehiclePart);
            return convertToDTO(savedVehiclePart);
        }
        return null;
    }

    public VehiclePartDTO updateVehiclePartFromDTO(Long vehicleId, Long partId, VehiclePartDTO vehiclePartDTO) {
        VehiclePartId id = new VehiclePartId(vehicleId, partId);
        if (vehiclePartRepository.existsById(id)) {
            VehiclePart vehiclePart = convertToEntity(vehiclePartDTO);
            if (vehiclePart != null) {
                VehiclePart updatedVehiclePart = updateVehiclePart(id, vehiclePart);
                return updatedVehiclePart != null ? convertToDTO(updatedVehiclePart) : null;
            }
        }
        return null;
    }

    // Helper methods for DTO conversion
    private VehiclePartDTO convertToDTO(VehiclePart vehiclePart) {
        VehiclePartDTO dto = new VehiclePartDTO();
        dto.setVehicleId(vehiclePart.getId().getVehicleId());
        dto.setPartId(vehiclePart.getId().getPartId());
        dto.setQuantity(vehiclePart.getQuantity());
        return dto;
    }

    private VehiclePart convertToEntity(VehiclePartDTO dto) {
        VehiclePart vehiclePart = new VehiclePart();
        
        // Create the composite ID
        VehiclePartId id = new VehiclePartId(dto.getVehicleId(), dto.getPartId());
        vehiclePart.setId(id);
        vehiclePart.setQuantity(dto.getQuantity());
        
        // Fetch the vehicle and part by ID
        Vehicle vehicle = vehicleService.getVehicleById(dto.getVehicleId());
        Part part = partService.getPartById(dto.getPartId());
        
        if (vehicle == null || part == null) {
            return null; // Vehicle or Part not found
        }
        
        vehiclePart.setVehicle(vehicle);
        vehiclePart.setPart(part);
        
        return vehiclePart;
    }
}
