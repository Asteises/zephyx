package ru.asteises.zephyx.airport.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "airports")
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iata_code", unique = true, length = 3)
    private String iataCode;

    @Column(name = "icao_code", length = 4)
    private String icaoCode;

    @Column(name = "name_rus")
    private String nameRus;

    @Column(name = "name_eng")
    private String nameEng;

    @Column(name = "city_rus")
    private String cityRus;

    @Column(name = "city_eng")
    private String cityEng;

    @Column(name = "gmt_offset")
    private String gmtOffset;

    @Column(name = "country_rus")
    private String countryRus;

    @Column(name = "country_eng")
    private String countryEng;

    @Column(name = "iso_code", length = 2)
    private String isoCode;

    // широта
    @Column(name = "latitude")
    private Double latitude;

    // долгота
    @Column(name = "longitude")
    private Double longitude;

    // длина взлетной полосы
    @Column(name = "runway_length")
    private Integer runwayLength;

    // высота над уровнем моря
    @Column(name = "runway_elevation")
    private Integer runwayElevation;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;
}
