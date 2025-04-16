package ru.asteises.zephyx.commons.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightOffersSearchResponse {

    private List<FlightOffer> data;
    private Dictionaries dictionaries;
    private Meta meta;
    private List<Warning> warnings;
}
