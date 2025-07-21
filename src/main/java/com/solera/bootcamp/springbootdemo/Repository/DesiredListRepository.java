package com.solera.bootcamp.springbootdemo.Repository;
import org.springframework.data.repository.CrudRepository;
import com.solera.bootcamp.springbootdemo.models.DesiredListByMonth;

public interface DesiredListRepository extends CrudRepository<DesiredListByMonth, Long> {
    // Additional query methods can be defined here if needed
}