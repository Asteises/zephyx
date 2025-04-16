package ru.asteises.zephyx.commons.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Segment {

    private Airport departure;
    private Airport arrival;
    private String carrierCode;
    private String number;
    private Aircraft aircraft;
    private String duration;
    private String id;
    private int numberOfStops;
    private boolean blacklistedInEU;
    private Co2Emissions co2Emissions;
}
