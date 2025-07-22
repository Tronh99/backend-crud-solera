package com.solera.bootcamp.springbootdemo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    
    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be greater than 0")
    @Max(value = 9999, message = "Quantity cannot exceed 9999")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull(message = "Vehicle is required")
    @ManyToOne
    @MapsId("vehicleId")
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    
    @NotNull(message = "Part is required")
    @ManyToOne
    @MapsId("partId")
    @JoinColumn(name = "part_id")
    private Part part;
}
