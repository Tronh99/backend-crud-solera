package com.solera.bootcamp.springbootdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnore
    private Location category;

    @ManyToMany
    @JoinTable(name = "product_desidered_list",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "desiderd_list_id"))
    private List<DesiredListByMonth> desiredListByMonth;

}