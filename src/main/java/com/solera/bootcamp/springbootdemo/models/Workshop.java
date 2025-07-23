package com.solera.bootcamp.springbootdemo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "Workshop")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workshop_id")
    private Long workshopId;
    
    @NotBlank(message = "Workshop name is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Workshop name must contain only letters, numbers, and spaces")
    @Size(max = 200, message = "Workshop name must not exceed 200 characters")
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Part name must contain only letters, numbers, and spaces")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Location is required")
    @OneToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "workshop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;
}