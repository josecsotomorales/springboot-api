package com.jose.bootstrap.web;

import com.jose.bootstrap.entity.Dog;
import com.jose.bootstrap.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) { this.dogService = dogService; }

    @GetMapping()
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> list = dogService.retrieveAllDogs();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable("id") Long id) {
        try {
            Dog dog = dogService.retrieveDogById(id);
            return new ResponseEntity<>(dog, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/breed")
    public ResponseEntity<List<String>> getAllDogBreeds() {
        List<String> list = dogService.retrieveDogBreeds();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/breed/{id}")
    public ResponseEntity<String> getDogBreedById(@PathVariable("id") Long id) {
        try {
            String dog = dogService.retrieveDogBreedById(id);
            return new ResponseEntity<>(dog, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
