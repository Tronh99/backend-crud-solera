package com.solera.bootcamp.springbootdemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkshopDTO {
    
    private Long workshopId;
    
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Workshop name must contain only letters, numbers, and spaces")
    @NotBlank(message = "Workshop name is required")
    @Size(max = 200, message = "Workshop name must not exceed 200 characters")
    private String name;
    
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Description must contain only letters, numbers, and spaces")
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;
    
    @NotNull(message = "Location ID is required")
    private Long locationId;
}
