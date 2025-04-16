package ru.asteises.zephyx.airport.model;

import lombok.*;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Airport {

    private String iataCode;

    private String icaoCode;

    private String nameRus;

    private String nameEng;

    private String cityRus;

    private String cityEng;

    private String gmtOffset;

    private String countryRus;

    private String countryEng;

    private String isoCode;

    // широта
    private Double latitude;

    // долгота
    private Double longitude;

    // длина взлетной полосы
    private Integer runwayLength;

    // высота над уровнем моря
    private Integer runwayElevation;

    private String phone;

    private String email;

    private String website;
}
