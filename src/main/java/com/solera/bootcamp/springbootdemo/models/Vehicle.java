package com.solera.bootcamp.springbootdemo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "Vehicles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long vehicleId;
    
    @Column(name = "model", nullable = false, length = 200)
    private String model;
    
    @Column(name = "brand", nullable = false, length = 200)
    private String brand;
    
    @Column(name = "vehicleYear", nullable = false, length = 4)
    private String year;
    
    @Column(name = "color", nullable = false, length = 200)
    private String color;
    
    @Column(name = "vin", nullable = false, length = 17, unique = true)
    private String vin;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehiclePart> vehicleParts;
}