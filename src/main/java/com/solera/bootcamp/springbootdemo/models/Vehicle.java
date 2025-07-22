package com.solera.bootcamp.springbootdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    public Long Id;
    public String Model;
    public String Brand;
    public int year;
    public String Color;
    public String VIN;
    public int quantity;

    @OneToMany(mappedBy = "parts")
    private List<Part> parts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workshop_id")
    @JsonIgnore
    private Workshop workshop;

}