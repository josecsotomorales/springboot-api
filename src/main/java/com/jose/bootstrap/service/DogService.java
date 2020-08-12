package com.jose.bootstrap.service;

import com.jose.bootstrap.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveAllDogs();
    Dog retrieveDogById(Long dogId);
    String retrieveDogBreed(Dog dog);
    String retrieveDogBreedById(Long dogId);
    List<String> retrieveDogNames();
    List<String> retrieveDogBreeds();
    List<String> retrieveDogOrigins();
}