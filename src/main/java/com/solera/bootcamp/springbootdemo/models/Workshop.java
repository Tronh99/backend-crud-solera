package com.solera.bootcamp.springbootdemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Workshop {
    @Id
    private Long id;
    private String name;
    private String description;

    @OneToOne(mappedBy = "location")
    private Long locationId;

    @OneToMany(mappedBy = "vehicles")
    private Long vehicleId;
}