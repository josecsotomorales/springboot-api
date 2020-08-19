package com.jose.bootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jose.bootstrap.entity.Dog;
import com.jose.bootstrap.exception.DogNotFoundGraphQLException;
import com.jose.bootstrap.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DogQuery implements GraphQLQueryResolver {
    private final DogRepository dogRepository;

    public DogQuery(DogRepository dogRepository) { this.dogRepository = dogRepository; }

    public Iterable<Dog> findAllDogs() { return dogRepository.findAll(); }

    public List<String> findDogBreeds() { return dogRepository.findAllBreed(); }

    public List<String> findAllDogNames() { return dogRepository.findAllName(); }

    public String findDogBreedById(Long id) { return dogRepository.findBreedById(id); }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundGraphQLException("Dog Not Found", id);
        }
    }

}
