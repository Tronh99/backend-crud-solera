package com.solera.bootcamp.springbootdemo.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solera.bootcamp.springbootdemo.Repository.LocationRepository;
import com.solera.bootcamp.springbootdemo.models.Location;
import com.solera.bootcamp.springbootdemo.dto.LocationDTO;

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

    // DTO Methods
    public List<LocationDTO> getAllLocationsDTO() {
        return getAllLocations().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public LocationDTO getLocationDTOById(Long id) {
        Location location = getLocationById(id);
        return location != null ? convertToDTO(location) : null;
    }

    public LocationDTO createLocationFromDTO(LocationDTO locationDTO) {
        Location location = convertToEntity(locationDTO);
        Location savedLocation = createLocation(location);
        return convertToDTO(savedLocation);
    }

    public LocationDTO updateLocationFromDTO(Long id, LocationDTO locationDTO) {
        if (locationRepository.existsById(id)) {
            Location location = convertToEntity(locationDTO);
            Location updatedLocation = updateLocation(id, location);
            return updatedLocation != null ? convertToDTO(updatedLocation) : null;
        }
        return null;
    }

    // Helper methods for DTO conversion
    private LocationDTO convertToDTO(Location location) {
        LocationDTO dto = new LocationDTO();
        dto.setLocationId(location.getLocationId());
        dto.setName(location.getName());
        dto.setStreet(location.getStreet());
        dto.setExtNumber(location.getExtNumber());
        dto.setPostalCode(location.getPostalCode());
        dto.setCity(location.getCity());
        dto.setCountry(location.getCountry());
        return dto;
    }

    private Location convertToEntity(LocationDTO dto) {
        Location location = new Location();
        location.setLocationId(dto.getLocationId());
        location.setName(dto.getName());
        location.setStreet(dto.getStreet());
        location.setExtNumber(dto.getExtNumber());
        location.setPostalCode(dto.getPostalCode());
        location.setCity(dto.getCity());
        location.setCountry(dto.getCountry());
        return location;
    }
}
