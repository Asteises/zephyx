package ru.asteises.zephyx.commons.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FareDetailsBySegment {

    private String segmentId;
    private String cabin;
    private String fareBasis;
    private String brandedFare;
    @JsonProperty("class")
    private String bookingClass;
    private IncludedCheckedBags includedCheckedBags;
    private BaggageAllowance baggageAllowance;
}
