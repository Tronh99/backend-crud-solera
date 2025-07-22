package com.solera.bootcamp.springbootdemo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "Location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {
    @Id
    @Column(name = "location_id")
    private Long locationId;
    
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    
    @Column(name = "street", nullable = false, length = 200)
    private String street;
    
    @Column(name = "ext_number", nullable = false, length = 20)
    private String extNumber;
    
    @Column(name = "postal_code", nullable = false, length = 5)
    private String postalCode;
    
    @Column(name = "city", nullable = false, length = 200)
    private String city;
    
    @Column(name = "country", nullable = false, length = 200)
    private String country;

<<<<<<< Updated upstream
    @OneToOne(mappedBy = "location")
    private Workshop workshop;
=======
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Workshop> workshops;
>>>>>>> Stashed changes
}
