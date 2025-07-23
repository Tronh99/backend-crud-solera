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
public class LocationDTO {
    
    private Long locationId;
    
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Location name must contain only letters, numbers, and spaces")
    @NotBlank(message = "Location name is required")
    @Size(max = 200, message = "Location name must have a maximum of 200 characters")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Street name must contain only letters, numbers, and spaces")
    @NotBlank(message = "Street name is required")
    @Size(max = 200, message = "Street name must have a maximum of 200 characters")
    private String street;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Exterior number must contain only letters, numbers, and spaces")
    @NotBlank(message = "Exterior number is required")
    @Size(max = 5, message = "Exterior number must have a maximum of 5 characters")
    private String extNumber;

    @Pattern(regexp = "^[0-9]+$", message = "Postal code must contain only numbers")
    @NotBlank(message = "Postal code is required")
    @Size(max = 5, message = "Postal code must have a maximum of 5 characters")
    private String postalCode;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "City must contain only letters, numbers, and spaces")
    @NotBlank(message = "City is required")
    @Size(max = 200, message = "City must have a maximum of 200 characters")
    private String city;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "State must contain only letters, numbers, and spaces")
    @NotBlank(message = "State is required")
    @Size(max = 200, message = "State must have a maximum of 200 characters")
    private String state;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Country must contain only letters, numbers, and spaces")
    @NotBlank(message = "Country is required")
    @Size(max = 200, message = "Country must have a maximum of 200 characters")
    private String country;
}
