package com.solera.bootcamp.springbootdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Location name must contain only letters, numbers, and spaces")
    @NotBlank(message = "Location name is required")
    @Size(max = 200, message = "Location name must have a maximum of 200 characters")
    @Column(name = "name")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Street name must contain only letters, numbers, and spaces")
    @NotBlank(message = "Street name is required")
    @Size(max = 200, message = "Street name must have a maximum of 200 characters")
    @Column(name = "street")
    private String street;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Exterior number must contain only letters, numbers, and spaces")
    @NotBlank(message = "Exterior number is required")
    @Size(max = 5, message = "Exterior number must have a maximum of 5 characters")
    @Column(name = "ext_number")
    private String extNumber;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Postal code must contain only letters, numbers, and spaces")
    @NotBlank(message = "Postal code is required")
    @Size(max = 5, message = "Postal code must have a maximum of 5 characters")
    @Column(name = "postal_code")
    private String postalCode;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "City must contain only letters, numbers, and spaces")
    @NotBlank(message = "City is required")
    @Size(max = 200, message = "City must have a maximum of 200 characters")
    @Column(name = "city")
    private String city;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Country must contain only letters, numbers, and spaces")
    @NotBlank(message = "Country is required")
    @Size(max = 200, message = "Country must have a maximum of 200 characters")
    @Column(name = "country")
    private String country;

    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Workshop workshop;
}