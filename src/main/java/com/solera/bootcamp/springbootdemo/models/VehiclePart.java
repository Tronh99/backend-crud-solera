package com.solera.bootcamp.springbootdemo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "VehiclePart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclePart {
    
    @EmbeddedId
    private VehiclePartId id;
    
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @MapsId("vehicleId")
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    
    @ManyToOne
    @MapsId("partId")
    @JoinColumn(name = "part_id")
    private Part part;
}
