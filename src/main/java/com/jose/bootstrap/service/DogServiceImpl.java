package com.jose.bootstrap.service;

import com.jose.bootstrap.entity.Dog;
import com.jose.bootstrap.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveAllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    public Dog retrieveDogById(Long dogId) {
        return dogRepository.findById(dogId).orElseThrow(EntityNotFoundException::new);
    }

    public String retrieveDogBreed(Dog dog) {
        return dog.getBreed();
    }

    public String retrieveDogBreedById(Long dogId) {
        return dogRepository.findById(dogId).orElseThrow(EntityNotFoundException::new).getBreed();
    }

    public List<String> retrieveDogNames() {
        Iterable<Dog> dogList = dogRepository.findAll();
        List<String> nameList = new ArrayList<>();
        dogList.forEach(it -> nameList.add(it.getName()));
        return nameList;
    }

    public List<String> retrieveDogBreeds() {
        Iterable<Dog> dogList = dogRepository.findAll();
        List<String> breedList = new ArrayList<>();
        dogList.forEach(it -> breedList.add(it.getBreed()));
        return breedList;
    }

    public List<String> retrieveDogOrigins() {
        Iterable<Dog> dogList = dogRepository.findAll();
        List<String> originList = new ArrayList<>();
        dogList.forEach(it -> originList.add(it.getOrigin()));
        return originList;
    }



}
