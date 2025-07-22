package com.solera.bootcamp.springbootdemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.solera.bootcamp.springbootdemo.models.Workshop;

@Repository
public interface WorkshopRepository extends CrudRepository<Workshop, Long> {
}
