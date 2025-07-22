package com.solera.bootcamp.springbootdemo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Workshop")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Workshop {
    @Id
    @Column(name = "workshop_id")
    private Long workshopId;
    
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    
    @Column(name = "description")
    private String description;

<<<<<<< Updated upstream
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToMany(mappedBy = "workshop")
    private List<Vehicle> vehicles = new ArrayList<>();
=======
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "workshop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;
>>>>>>> Stashed changes
}