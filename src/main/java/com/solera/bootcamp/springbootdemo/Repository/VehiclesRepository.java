package com.solera.bootcamp.springbootdemo.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.solera.bootcamp.springbootdemo.models.Vehicle;

@Repository
public interface VehiclesRepository extends CrudRepository<Vehicle, Long> {

    @Query("""
                SELECT SUM(p.cost * vp.quantity)
                FROM VehiclePart vp
                JOIN vp.part p
                WHERE vp.vehicle.vehicleId = :vehicleId
            """)
    Double getTotalCostByVehicle(@Param("vehicleId") Long vehicleId);

    // Debug query to check if vehicle parts exist
    @Query("""
                SELECT COUNT(vp)
                FROM VehiclePart vp
                WHERE vp.vehicle.vehicleId = :vehicleId
            """)
    Long countVehiclePartsByVehicleId(@Param("vehicleId") Long vehicleId);

}