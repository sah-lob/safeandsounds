package ru.sahlob.persistance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Type;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputTour {

    @Type(type = "text")
    private String image;
    private String name;
    private String description;
    private Integer price;
}
