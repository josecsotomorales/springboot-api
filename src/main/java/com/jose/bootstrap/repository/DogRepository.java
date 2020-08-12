package com.jose.bootstrap.repository;

import com.jose.bootstrap.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}