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
    @Size(max = 200, message = "Part name must not exceed 200 characters")
    private String name;
    
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;
    
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;
    
    @NotNull(message = "Cost is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Cost must be greater than or equal to 0")
    @Digits(integer = 8, fraction = 2, message = "Cost must have at most 8 digits before decimal and 2 after")
    private BigDecimal cost;
}
