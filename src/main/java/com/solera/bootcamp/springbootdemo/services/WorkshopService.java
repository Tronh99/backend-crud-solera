package com.solera.bootcamp.springbootdemo.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solera.bootcamp.springbootdemo.Repository.WorkshopRepository;
import com.solera.bootcamp.springbootdemo.models.Workshop;
import com.solera.bootcamp.springbootdemo.models.Location;
import com.solera.bootcamp.springbootdemo.dto.WorkshopDTO;

@Service
public class WorkshopService {

    @Autowired
    private WorkshopRepository workshopRepository;

    @Autowired
    private LocationService locationService;

    public List<Workshop> getAllWorkshops() {
        return (List<Workshop>) workshopRepository.findAll();
    }

    public Workshop getWorkshopById(Long id) {
        return workshopRepository.findById(id).orElse(null);
    }

    public Workshop createWorkshop(Workshop workshop) {
        return workshopRepository.save(workshop);
    }

    public Workshop updateWorkshop(Long id, Workshop workshop) {
        if (workshopRepository.existsById(id)) {
            workshop.setWorkshopId(id);
            return workshopRepository.save(workshop);
        }
        return null;
    }

    public boolean deleteWorkshop(Long id) {
        if (workshopRepository.existsById(id)) {
            workshopRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsById(Long id) {
        return workshopRepository.existsById(id);
    }

    // DTO Methods
    public List<WorkshopDTO> getAllWorkshopsDTO() {
        return getAllWorkshops().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public WorkshopDTO getWorkshopDTOById(Long id) {
        Workshop workshop = getWorkshopById(id);
        return workshop != null ? convertToDTO(workshop) : null;
    }

    public WorkshopDTO createWorkshopFromDTO(WorkshopDTO workshopDTO) {
        Workshop workshop = convertToEntity(workshopDTO);
        if (workshop != null) {
            Workshop savedWorkshop = createWorkshop(workshop);
            return convertToDTO(savedWorkshop);
        }
        return null;
    }

    public WorkshopDTO updateWorkshopFromDTO(Long id, WorkshopDTO workshopDTO) {
        if (workshopRepository.existsById(id)) {
            Workshop workshop = convertToEntity(workshopDTO);
            if (workshop != null) {
                Workshop updatedWorkshop = updateWorkshop(id, workshop);
                return updatedWorkshop != null ? convertToDTO(updatedWorkshop) : null;
            }
        }
        return null;
    }

    // Helper methods for DTO conversion
    private WorkshopDTO convertToDTO(Workshop workshop) {
        WorkshopDTO dto = new WorkshopDTO();
        dto.setWorkshopId(workshop.getWorkshopId());
        dto.setName(workshop.getName());
        dto.setDescription(workshop.getDescription());
        dto.setLocationId(workshop.getLocation().getLocationId());
        return dto;
    }

    private Workshop convertToEntity(WorkshopDTO dto) {
        Workshop workshop = new Workshop();
        workshop.setWorkshopId(dto.getWorkshopId());
        workshop.setName(dto.getName());
        workshop.setDescription(dto.getDescription());
        
        // Fetch the location by ID
        Location location = locationService.getLocationById(dto.getLocationId());
        if (location == null) {
            return null; // Location not found
        }
        workshop.setLocation(location);
        
        return workshop;
    }
}
