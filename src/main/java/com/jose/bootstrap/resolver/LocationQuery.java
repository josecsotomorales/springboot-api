package com.jose.bootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jose.bootstrap.entity.Location;
import com.jose.bootstrap.repository.LocationRepository;
import org.springframework.stereotype.Component;

@Component
public class LocationQuery implements GraphQLQueryResolver {
    private final LocationRepository locationRepository;

    public LocationQuery(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Iterable<Location> findAllLocations() {
        return locationRepository.findAll();
    }
}

