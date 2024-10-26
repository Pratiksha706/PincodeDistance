package com.frightfox.poc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frightfox.poc.entity.Route;

import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    Optional<Route> findByFromPincodeAndToPincode(String fromPincode, String toPincode);
}
