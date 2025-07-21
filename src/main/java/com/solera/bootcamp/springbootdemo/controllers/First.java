package com.solera.bootcamp.springbootdemo.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.solera.bootcamp.springbootdemo.models.Product;
import com.solera.bootcamp.springbootdemo.Repository.ProductRepository;

@RestController
@RequestMapping("/API/v1")
public class First {
    /*@RequestMapping(value ="/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello from the first API!";
    }*/

    private ProductRepository productRepository;

    public First(ProductRepository repository) {
        productRepository = repository;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "nombre", defaultValue = "Mundo") String nombre) {
        return "Hello" + " " + nombre;
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).get();
        if (product == null) {
            return  "Product not found with ID: " + id;
        }
        return "Product found: " + product.getName();
    }

    @GetMapping("/product")
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @PostMapping("/product")
    public String postHello(@RequestBody Product product) {
        //return "The product name is: " + product.Name;
        if (product.getId() != null) {
            product.setId(null); // Ensure the ID is null for new products
        }
        productRepository.save(product);
        return "The product " + product.getName() + " has been saved successfully!";
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "The product with ID " + id + " has been deleted successfully!";
    }
}
