package com.solera.bootcamp.springbootdemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.solera.bootcamp.springbootdemo.models.Part;

@Repository
public interface PartRepository extends CrudRepository<Part, Long> {
}
