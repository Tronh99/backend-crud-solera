package com.solera.bootcamp.springbootdemo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solera.bootcamp.springbootdemo.Repository.WorkshopRepository;
import com.solera.bootcamp.springbootdemo.models.Workshop;

@Service
public class WorkshopService {

    @Autowired
    private WorkshopRepository workshopRepository;

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
}
