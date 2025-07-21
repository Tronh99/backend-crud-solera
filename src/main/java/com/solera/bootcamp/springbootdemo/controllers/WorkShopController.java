package com.solera.bootcamp.springbootdemo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/workshops")
public class WorkShopController {

    @GetMapping("/{id}")    
    public List<Workshop> getWorkShopById(@PathVariable Long id) {
        return new ArrayList<>();
    }

    @GetMapping
    public String getAllWorkshops() {
        return new String();
    }   
    

    @PostMapping
    public String createWorkShop(@RequestBody Workshop workshop) {
        return "Workshop created successfully";
    }

    @PutMapping("/{id}")
    public String updateWorkShop(@PathVariable Long id, @RequestBody Workshop workshop) {
        return "Workshop with ID: " + id + " updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteWorkShop(@PathVariable Long id) {
        return "Workshop with ID: " + id + " deleted successfully";
    }

}
