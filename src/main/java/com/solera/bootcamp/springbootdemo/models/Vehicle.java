package com.solera.bootcamp.springbootdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message = "Model cannot be empty")
    @Size(max = 200, message = "Model cannot exceed 200 characters")
    @Column(name = "model", nullable = false, length = 200)
    private String model;

    @NotBlank(message = "Brand cannot be empty")
    @Size(max = 200, message = "Brand cannot exceed 200 characters")
    @Column(name = "brand", nullable = false, length = 200)
    private String brand;

    @NotBlank(message = "Year cannot be empty")
    @Pattern(regexp = "\\d{4}", message = "Year must be 4 digits")
    @Column(name = "vehicleYear", nullable = false, length = 4)
    private String year;

    @NotBlank(message = "Color cannot be empty")
    @Size(max = 200, message = "Color cannot exceed 200 characters")
    @Column(name = "color", nullable = false, length = 200)
    private String color;

    @NotBlank(message = "VIN cannot be empty")
    @Size(min = 17, max = 17, message = "VIN must be exactly 17 characters")
    @Column(name = "vin", nullable = false, length = 17, unique = true)
    private String vin;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;
    
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<VehiclePart> vehicleParts;

}