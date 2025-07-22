package com.solera.bootcamp.springbootdemo.controllers;

import com.solera.bootcamp.springbootdemo.models.Part;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.bootcamp.springbootdemo.models.Workshop;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/parts")
public class PartsController {

     @GetMapping("/{id}")    
    public String getPartById(@PathVariable Long id) {
        return "";
    }

    @GetMapping
    public List<Part> getAllParts() {
        return new ArrayList<>();
    }


    @PostMapping
    public String createPart(@RequestBody Part part) {
        return "Part created successfully";
    }

    @PutMapping("/{id}")
    public String updatePart(@PathVariable Long id, @RequestBody Part part) {
        return "Part with ID: " + id + " updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deletePart(@PathVariable Long id) {
        return "Part with ID: " + id + " deleted successfully";
    }

}
