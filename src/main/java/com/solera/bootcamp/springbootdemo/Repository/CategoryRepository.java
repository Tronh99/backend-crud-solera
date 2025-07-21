package com.solera.bootcamp.springbootdemo.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.solera.bootcamp.springbootdemo.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
