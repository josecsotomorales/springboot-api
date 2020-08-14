package com.jose.bootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jose.bootstrap.entity.Location;
import com.jose.bootstrap.repository.LocationRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private final LocationRepository locationRepository;

    public Query(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Iterable<Location> findAllLocations() {
        return locationRepository.findAll();
    }
}

