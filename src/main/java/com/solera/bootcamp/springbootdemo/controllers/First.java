package com.solera.bootcamp.springbootdemo;


import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solera.bootcamp.springbootdemo.Models.Product;
import com.solera.bootcamp.springbootdemo.repository.ProductRepository;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1")
public class First {

    private static ProductRepository productRepository;

    public First(ProductRepository repository) {
        productRepository = repository;
    }


    @GetMapping("/workshops")
    public Iterable<Workshop> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/vehicles")
    public Iterable<Workshop> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/parts")
    public Iterable<Workshop> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/locations")
    public Iterable<Workshop> getProducts() {
        return productRepository.findAll();
    }


    @PostMapping("/products/{id}")
    public int getProductById(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return "Product found: " + product.get().getName() + " with ID: " + product.get().getId();
        } else {
            return "Product with ID: " + id + " not found.";
        }
    }

    @PostMapping("/parts/{id}")
    public int getProductById(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return "Product found: " + product.get().getName() + " with ID: " + product.get().getId();
        } else {
            return "Product with ID: " + id + " not found.";
        }
    }

    @PostMapping("/workshops/{id}")
    public String postProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "Product saved: " + product.getName() + " has been added with ID: " + product.getId() + " saved successfully!";
    }

    @PostMapping("/locations/{id}")
    public String postProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "Product saved: " + product.getName() + " has been added with ID: " + product.getId() + " saved successfully!";
    }

    @PutMapping("/products/{id}")
    public int getProductById(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return "Product found: " + product.get().getName() + " with ID: " + product.get().getId();
        } else {
            return "Product with ID: " + id + " not found.";
        }
    }

    @PutMapping("/parts/{id}")
    public int getProductById(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return "Product found: " + product.get().getName() + " with ID: " + product.get().getId();
        } else {
            return "Product with ID: " + id + " not found.";
        }
    }

    @PutMapping("/workshops/{id}")
    public String postProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "Product saved: " + product.getName() + " has been added with ID: " + product.getId() + " saved successfully!";
    }

    @PutMapping("/locations/{id}")
    public String postProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "Product saved: " + product.getName() + " has been added with ID: " + product.getId() + " saved successfully!";
    }


    @DeleteMapping("/products/{id}")
    public Long deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "Product with ID: " + id + " has been deleted successfully!";
    }

    @DeleteMapping("/parts/{id}")
    public int getProductById(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return "Product found: " + product.get().getName() + " with ID: " + product.get().getId();
        } else {
            return "Product with ID: " + id + " not found.";
        }
    }

    @DeleteMapping("/workshops/{id}")
    public String postProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "Product saved: " + product.getName() + " has been added with ID: " + product.getId() + " saved successfully!";
    }

    @DeleteMapping("/locations/{id}")
    public String postProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "Product saved: " + product.getName() + " has been added with ID: " + product.getId() + " saved successfully!";
    }
}
