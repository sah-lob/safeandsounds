package ru.sahlob.persistance.tour;

import lombok.Data;

@Data
public class LikedTour {
    private int id;
    private String name;

    public LikedTour(Tour tour) {
        this.id = tour.getId();
        this.name = tour.getName();
    }
}
