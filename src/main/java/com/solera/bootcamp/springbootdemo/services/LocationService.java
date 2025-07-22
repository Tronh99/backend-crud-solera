package com.solera.bootcamp.springbootdemo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solera.bootcamp.springbootdemo.Repository.LocationRepository;
import com.solera.bootcamp.springbootdemo.models.Location;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    public Location getLocationById(Long id) {


        return locationRepository.findById(id).orElse(null);

    }

    public Location createLocation(Location location) {
            return locationRepository.save(location);
    }


    public Location updateLocation(Long id, Location location) {
        if (locationRepository.existsById(id)) {
            location.setLocationId(id);
            return locationRepository.save(location);
        }
        return null;
    }

    public boolean deleteLocation(Long id) {
        if (locationRepository.existsById(id)) {
            locationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existsById(Long id) {
        return locationRepository.existsById(id);
    }
}
