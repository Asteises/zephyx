package ru.asteises.zephyx.airport.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.asteises.zephyx.airport.model.AirportEntity;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Long> {

    List<AirportEntity> findByCountryEng(String countryEng);
    List<AirportEntity> findByCountryRus(String countryRus);

    List<AirportEntity> findByCityEng(String cityEng);
    List<AirportEntity> findByCityRus(String cityRus);

    AirportEntity findByIataCode(String iataCode);
    AirportEntity findByIcaoCode(String icaoCode);
}
