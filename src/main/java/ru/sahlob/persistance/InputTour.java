package ru.sahlob.persistance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputTour {
    private MultipartFile file;
    private String name;
    private String description;
    private Integer price;
    private Integer coolness;
}
