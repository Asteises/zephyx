package ru.asteises.zephyx.commons.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightSearchRequest {

    @NotBlank
    private String originLocationCode; // city/airport [IATA code]

    @NotBlank
    private String destinationLocationCode; // city/airport [IATA code]

    @NotBlank
    @Pattern(regexp = "YYYY-MM-DD")
    private String departureDate;

    @Pattern(regexp = "YYYY-MM-DD")
    private String returnDate;

    /*
    the number of adult travelers (age 12 or older on date of departure).
    The total number of seated travelers (adult and children) can not exceed 9.
     */
    @NotBlank
    @NotNull
    @Min(1)
    @Max(9)
    private Integer adults;

    /*
    the number of child travelers (older than age 2 and younger than age 12 on date of departure) who will each have
    their own separate seat. If specified, this number should be greater than or equal to 0\n\nThe total number of
    seated travelers (adult and children) can not exceed 9.
     */
    @Min(0)
    @Max(9)
    private Integer children;

    /*
    the number of infant travelers (whose age is less or equal to 2 on date of departure). Infants travel on the lap
    of an adult traveler, and thus the number of infants must not exceed the number of adults. If specified, this
    number should be greater than or equal to 0
     */
    @Min(0)
    @Max(9)
    private Integer infants;

    private String travelClass; // "ECONOMY", "PREMIUM_ECONOMY", "BUSINESS", "FIRST"

    private String includedAirlineCodes; // [IATA airline codes] csv format, example: 6X,7X,8X

    private String excludedAirlineCodes; // [IATA airline codes] csv format, example: 6X,7X,8X

    private Boolean nonStop; // Без пересадок

    private String currencyCode; // Валюта [ISO 4217] format, e.g. EUR for Euro

    private Integer maxPrice; // maximum price per traveler. By default, no limit is applied. If specified, the value should be a positive number with no decimals

    @Min(1)
    private Integer max; // maximum number of flight offers to return. If specified, the value should be greater than or equal to 1
}