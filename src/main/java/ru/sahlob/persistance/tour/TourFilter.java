package ru.sahlob.persistance.tour;

import lombok.Data;

import java.util.Set;

@Data
public class TourFilter {
    private Set<Integer> likedToursId;
    private boolean lt;
    private Integer durationFrom;
    private Integer durationTo;
    private Integer hourFrom;
    private Integer hourTo;
    private Integer priceFrom;
    private Integer priceTo;
}
