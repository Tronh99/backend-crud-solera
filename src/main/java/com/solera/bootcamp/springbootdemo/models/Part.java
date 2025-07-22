package com.solera.bootcamp.springbootdemo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Parts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    private Long partId;
    
    @NotBlank(message = "Part name is required")
    @Size(max = 200, message = "Part name must not exceed 200 characters")
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    @Column(name = "description")
    private String description;
    
    @Min(value = 0, message = "Quantity cannot be negative")
    @Column(name = "quantity")
    private Integer quantity;
    
    @NotNull(message = "Cost is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Cost must be greater than or equal to 0")
    @Digits(integer = 8, fraction = 2, message = "Cost must have at most 8 digits before decimal and 2 after")
    @Column(name = "cost", nullable = false, precision = 10, scale = 2)
    private BigDecimal cost;

    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehiclePart> vehicleParts;
}