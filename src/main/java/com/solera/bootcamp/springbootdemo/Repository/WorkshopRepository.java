package com.solera.bootcamp.springbootdemo.Repository;

import com.solera.bootcamp.springbootdemo.models.Workshop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkshopRepository extends CrudRepository<Workshop, Long> {
}
