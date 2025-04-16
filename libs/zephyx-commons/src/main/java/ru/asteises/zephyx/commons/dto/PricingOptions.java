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
public class PricingOptions {

    private boolean includedCheckedBagsOnly;
    private List<String> fareType;
    private boolean corporateCodes;
    private boolean refundableFare;
    private boolean noRestrictionFare;
    private boolean noPenaltyFare;
}
