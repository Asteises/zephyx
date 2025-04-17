package ru.asteises.zephyx.airport.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.asteises.zephyx.airport.model.AirportEntity;
import ru.asteises.zephyx.airport.repo.AirportRepository;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AirportDataLoader implements CommandLineRunner {

    private final AirportRepository airportRepository;

    @Override
    public void run(String... args) throws Exception {
        if (airportRepository.count() == 0) {
            List<AirportEntity> airports = AirportCsvParser.parse();
            log.info("Airports loaded: {}", airports.size());
            airportRepository.saveAll(airports);
            log.info("Airports saved");
        } else {
            log.info("There are already one airports in the database");
        }
    }
}
