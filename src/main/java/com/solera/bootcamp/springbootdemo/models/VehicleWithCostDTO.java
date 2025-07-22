package com.solera.bootcamp.springbootdemo.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleWithCostDTO {

    private Long vehicleId;
    private String model;
    private String brand;
    private String year;
    private String color;
    private String vin;
    private Double totalCost;




}
