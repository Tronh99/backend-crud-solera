package com.solera.bootcamp.springbootdemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.solera.bootcamp.springbootdemo.models.Part;

@Repository
public interface ProductRepository  extends CrudRepository<Part, Long> {}
