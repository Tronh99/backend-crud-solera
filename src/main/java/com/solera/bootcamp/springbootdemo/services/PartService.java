package com.solera.bootcamp.springbootdemo.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solera.bootcamp.springbootdemo.Repository.PartRepository;
import com.solera.bootcamp.springbootdemo.models.Part;
import com.solera.bootcamp.springbootdemo.dto.PartDTO;

@Service
public class PartService {

    @Autowired
    private PartRepository partRepository;

    public List<Part> getAllParts() {
        return (List<Part>) partRepository.findAll();
    }

    public Part getPartById(Long id) {
        return partRepository.findById(id).orElse(null);
    }

    public Part createPart(Part part) {
        return partRepository.save(part);
    }

    public Part updatePart(Long id, Part part) {
        if (partRepository.existsById(id)) {
            part.setPartId(id);
            return partRepository.save(part);
        }
        return null;
    }

    public boolean deletePart(Long id) {
        if (partRepository.existsById(id)) {
            partRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsById(Long id) {
        return partRepository.existsById(id);
    }

    // DTO Methods
    public List<PartDTO> getAllPartsDTO() {
        return getAllParts().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PartDTO getPartDTOById(Long id) {
        Part part = getPartById(id);
        return part != null ? convertToDTO(part) : null;
    }

    public PartDTO createPartFromDTO(PartDTO partDTO) {
        Part part = convertToEntity(partDTO);
        Part savedPart = createPart(part);
        return convertToDTO(savedPart);
    }

    public PartDTO updatePartFromDTO(Long id, PartDTO partDTO) {
        if (partRepository.existsById(id)) {
            Part part = convertToEntity(partDTO);
            Part updatedPart = updatePart(id, part);
            return updatedPart != null ? convertToDTO(updatedPart) : null;
        }
        return null;
    }

    // Helper methods for DTO conversion
    private PartDTO convertToDTO(Part part) {
        PartDTO dto = new PartDTO();
        dto.setPartId(part.getPartId());
        dto.setName(part.getName());
        dto.setDescription(part.getDescription());
        dto.setQuantity(part.getQuantity());
        dto.setCost(part.getCost());
        return dto;
    }

    private Part convertToEntity(PartDTO dto) {
        Part part = new Part();
        part.setPartId(dto.getPartId());
        part.setName(dto.getName());
        part.setDescription(dto.getDescription());
        part.setQuantity(dto.getQuantity());
        part.setCost(dto.getCost());
        return part;
    }
}
