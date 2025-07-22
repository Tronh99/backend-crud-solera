package com.solera.bootcamp.springbootdemo.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.solera.bootcamp.springbootdemo.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
}
