package ru.asteises.zephyx.airport.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.asteises.zephyx.airport.model.AirportEntity;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Long> {
}
