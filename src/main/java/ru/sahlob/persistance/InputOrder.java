package ru.sahlob.persistance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputOrder {
    private String tourType;
    private String tourDate;
    private int tourId;
}
