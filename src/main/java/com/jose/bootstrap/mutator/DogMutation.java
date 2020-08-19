package com.jose.bootstrap.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.jose.bootstrap.entity.Dog;
import com.jose.bootstrap.exception.DogNotFoundGraphQLException;
import com.jose.bootstrap.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DogMutation implements GraphQLMutationResolver {
    private final DogRepository dogRepository;

    public DogMutation(DogRepository dogRepository) { this.dogRepository = dogRepository; }

    public boolean deleteDogBreed(String breed) {
        return dogRepository.deleteDogByBreed(breed);
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog =
                dogRepository.findById(id);

        if(optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundGraphQLException("Dog Not Found", id);
        }
    }
}