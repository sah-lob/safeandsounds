package ru.sahlob.persistance.tour;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputTour {
    private MultipartFile file;
    private String name;
    private String smallDescription;
    private String description;
    private int duration;
    private Integer price1;
    private Integer price2;
    private Integer price3;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;
    private Integer coolness;
    private Integer beginningTourHour;
    private Integer beginningTourMinutes;
}
