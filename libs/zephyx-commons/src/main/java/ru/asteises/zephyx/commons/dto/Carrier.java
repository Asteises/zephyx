package ru.asteises.zephyx.commons.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Carrier {

    private String businessName;
    private String commonName;
    private String iataCode;
}
