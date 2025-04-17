package ru.asteises.flightsearch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.asteises.zephyx.airport.repo.AirportRepository;

@Service
@RequiredArgsConstructor
public class FlightSearchService {

    private final AirportRepository airportRepository;
}
