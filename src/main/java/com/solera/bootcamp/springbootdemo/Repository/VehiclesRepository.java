package com.solera.bootcamp.springbootdemo.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.solera.bootcamp.springbootdemo.models.Vehicle;

@Repository
public interface VehiclesRepository extends CrudRepository<Vehicle, Long> {

    @Query("""
                SELECT SUM(vp.quantity * p.cost)
                FROM Vehicle v
                JOIN v.vehicleParts vp
                JOIN vp.part p
                WHERE v.vehicleId = :id
            """)
    Double getTotalCostByVehicle(@Param("id") Long id);

}