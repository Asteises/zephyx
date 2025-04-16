package ru.asteises.zephyx.commons.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Map;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dictionaries {

    private Map<String, Location> locations;
    private Map<String, Aircraft> aircraft;
    private Map<String, Currency> currencies;
    private Map<String, Carrier> carriers;
}
