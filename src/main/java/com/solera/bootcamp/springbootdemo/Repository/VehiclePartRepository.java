package com.solera.bootcamp.springbootdemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.solera.bootcamp.springbootdemo.models.VehiclePart;
import com.solera.bootcamp.springbootdemo.models.VehiclePartId;

@Repository
public interface VehiclePartRepository extends CrudRepository<VehiclePart, VehiclePartId> {
}
