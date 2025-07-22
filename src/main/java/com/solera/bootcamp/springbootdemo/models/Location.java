package com.solera.bootcamp.springbootdemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {
    @Id
    private Long id;
    private String name;
    private String street;
    private int ext_number;
    private String postalCode;
    private String city;
    private String country;

    @OneToOne(mappedBy = "location")
    private Workshop workshop;
}