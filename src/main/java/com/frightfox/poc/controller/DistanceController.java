package com.frightfox.poc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frightfox.poc.model.RouteResponse;
import com.frightfox.poc.service.DistanceService;

@RestController
@RequestMapping("/api/v1")
public class DistanceController {
    @Autowired
    private DistanceService distanceService;

    @GetMapping("/pincode-distance")
    public ResponseEntity<RouteResponse> getDistance(
            @RequestParam String fromPincode, 
            @RequestParam String toPincode) {
        RouteResponse response = distanceService.getDistance(fromPincode, toPincode);
        return ResponseEntity.ok(response);
    }
}
