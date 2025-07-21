package com.solera.bootcamp.springbootdemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.solera.bootcamp.springbootdemo.models.Product;

@Repository
public interface ProductRepository  extends CrudRepository<Product, Long> {}
