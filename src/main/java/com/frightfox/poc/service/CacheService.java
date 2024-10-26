package com.frightfox.poc.service;


import org.springframework.stereotype.Service;

import com.frightfox.poc.model.RouteResponse;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

@Service
public class CacheService {
    private final Cache<String, RouteResponse> cache = Caffeine.newBuilder()
        .expireAfterWrite(10, TimeUnit.MINUTES)
        .maximumSize(100)
        .build();

    public RouteResponse getFromCache(String fromPincode, String toPincode) {
        return cache.getIfPresent(fromPincode + "_" + toPincode);
    }

    public void putInCache(String fromPincode, String toPincode, RouteResponse response) {
        cache.put(fromPincode + "_" + toPincode, response);
    }
}
