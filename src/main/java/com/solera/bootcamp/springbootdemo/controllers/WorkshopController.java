package com.solera.bootcamp.springbootdemo.controllers;

import com.solera.bootcamp.springbootdemo.models.Workshop;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/workshops")
public class WorkshopController {

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
