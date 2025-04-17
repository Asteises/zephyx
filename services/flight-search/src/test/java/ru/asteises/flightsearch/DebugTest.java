package ru.asteises.flightsearch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.asteises.zephyx.airport.repo.AirportRepository;

@SpringBootTest
class DebugTest {

    @Autowired(required = false)
    private AirportRepository airportRepo;

    @Test
    void contextLoads() {
        System.out.println("AirportRepo is null: " + (airportRepo == null));
    }
}
