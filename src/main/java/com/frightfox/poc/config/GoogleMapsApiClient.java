package com.frightfox.poc.config;


import java.util.Random;

import org.springframework.stereotype.Service;

import com.frightfox.poc.model.RouteResponse;

@Service
public class GoogleMapsApiClient {

    public RouteResponse getDistanceAndDuration(String fromPincode, String toPincode) {
    	Random random = new Random();
        Integer duartion = random.nextInt(10) + 1;
        Integer distance = random.nextInt(500)+ 200;
        return new RouteResponse(fromPincode, toPincode, distance, duartion.toString(), "Sample route");
    }
}
