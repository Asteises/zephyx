package ru.asteises.flightsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		scanBasePackages = {
				"ru.asteises.flightsearch",
				"ru.asteises.zephyx.airport"
		}
)
@EntityScan("ru.asteises.zephyx.airport.model")
@EnableJpaRepositories("ru.asteises.zephyx.airport.repo")
public class FlightSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSearchApplication.class, args);
	}

}
