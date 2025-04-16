package ru.asteises.zephyx.commons.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Warning {

    private int status;
    private String code;
    private String title;
    private String detail;
    private String source;
}
