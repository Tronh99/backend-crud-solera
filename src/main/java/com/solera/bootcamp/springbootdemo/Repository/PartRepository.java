package com.solera.bootcamp.springbootdemo.Repository;
import org.springframework.data.repository.CrudRepository;
import com.solera.bootcamp.springbootdemo.models.Part;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends CrudRepository<Part, Long> {
}
