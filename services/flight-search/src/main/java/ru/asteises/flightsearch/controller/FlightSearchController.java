package ru.asteises.flightsearch.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.asteises.zephyx.commons.dto.FlightOffersSearchResponse;
import ru.asteises.zephyx.commons.dto.FlightSearchRequest;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightSearchController {

    @Value("${amadeus.api.access.token}")
    private String amadeusAccessToken;

    @PostMapping("/search")
    public ResponseEntity<FlightOffersSearchResponse> searchFlights(@RequestBody FlightSearchRequest request) {
        return ResponseEntity.ok(null);
    }
}
