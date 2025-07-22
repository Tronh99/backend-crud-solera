package com.solera.bootcamp.springbootdemo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solera.bootcamp.springbootdemo.Repository.PartRepository;
import com.solera.bootcamp.springbootdemo.models.Part;

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
}
