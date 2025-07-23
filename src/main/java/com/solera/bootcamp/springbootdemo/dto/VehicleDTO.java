package com.solera.bootcamp.springbootdemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    
    private Long vehicleId;
    
    @NotBlank(message = "Model cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Model must contain only letters, numbers, and spaces")
    @Size(max = 200, message = "Model cannot exceed 200 characters")
    private String model;

    @NotBlank(message = "Brand cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Brand name must contain only letters, numbers, and spaces")
    @Size(max = 200, message = "Brand cannot exceed 200 characters")
    private String brand;

    @NotBlank(message = "Year cannot be empty")
    @Pattern(regexp = "\\d{4}", message = "Year must be 4 digits")
    private String year;

    @NotBlank(message = "Color cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Color must contain only letters, numbers, and spaces")
    @Size(max = 200, message = "Color cannot exceed 200 characters")
    private String color;

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "VIN must contain only letters and numbers")
    @NotBlank(message = "VIN cannot be empty")
    @Size(min = 17, max = 17, message = "VIN must be exactly 17 characters")
    private String vin;

    private Long workshopId;
}
