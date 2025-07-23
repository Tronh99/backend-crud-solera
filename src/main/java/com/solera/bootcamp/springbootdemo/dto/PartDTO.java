package com.solera.bootcamp.springbootdemo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartDTO {
    
    private Long partId;
    
    @NotBlank(message = "Part name is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Part name must contain only letters, numbers, and spaces")
    @Size(max = 200, message = "Part name must not exceed 200 characters")
    private String name;
    
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Part name must contain only letters, numbers, and spaces")
    private String description;
    
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
    
    @NotNull(message = "Cost is required")
    @DecimalMin(value = "0.1", inclusive = true, message = "Cost must be greater than or equal to 0.1")
    @Digits(integer = 8, fraction = 2, message = "Cost must have at most 8 digits before decimal and 2 after")
    private BigDecimal cost;
}
