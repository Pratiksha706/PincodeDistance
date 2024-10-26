package com.frightfox.poc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frightfox.poc.config.GoogleMapsApiClient;
import com.frightfox.poc.entity.Route;
import com.frightfox.poc.model.RouteResponse;
import com.frightfox.poc.repository.RouteRepository;

import java.util.Optional;

@Service
public class DistanceService {
    @Autowired
    private GoogleMapsApiClient googleMapsApiClient;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private RouteRepository routeRepository;

    public RouteResponse getDistance(String fromPincode, String toPincode) {
        // Check cache first
        RouteResponse cachedResponse = cacheService.getFromCache(fromPincode, toPincode);
        if (cachedResponse != null) {
            return cachedResponse;
        }

        // Check DB
        Optional<Route> route = routeRepository.findByFromPincodeAndToPincode(fromPincode, toPincode);
        if (route.isPresent()) {
            return new RouteResponse(route.get());
        }

        // Call Google Maps API
        RouteResponse apiResponse = googleMapsApiClient.getDistanceAndDuration(fromPincode, toPincode);

        // Save to DB and Cache
        routeRepository.save(new Route(fromPincode, toPincode, apiResponse.getDistance(), apiResponse.getDuration(), apiResponse.getRoute()));
        cacheService.putInCache(fromPincode, toPincode, apiResponse);

        return apiResponse;
    }
}
