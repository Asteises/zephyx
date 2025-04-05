package ru.asteises.zephyx.commons.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FlightSearchRequest {
    @NotBlank
    private String origin;
    @NotBlank
    private String destination;
    private String departureDate;
}