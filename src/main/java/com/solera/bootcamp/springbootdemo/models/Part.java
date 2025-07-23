package com.solera.bootcamp.springbootdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Part name must contain only letters, numbers, and spaces")
    @Size(max = 200, message = "Part name must not exceed 200 characters")
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Part name must contain only letters, numbers, and spaces")
    @Column(name = "description")
    private String description;

    @Min(value = 1, message = "Quantity must be at least 1")
    @Column(name = "quantity")
    private Integer quantity;
    
    @NotNull(message = "Cost is required")
    @DecimalMin(value = "0.1", inclusive = true, message = "Cost must be greater than or equal to 0")
    @Digits(integer = 8, fraction = 2, message = "Cost must have at most 8 digits before decimal and 2 after")
    @Column(name = "cost", nullable = false, precision = 10, scale = 2)
    private BigDecimal cost;

    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<VehiclePart> vehicleParts;
}