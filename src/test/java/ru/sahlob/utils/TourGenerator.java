package ru.sahlob.utils;

import ru.sahlob.persistance.tour.Tour;
import ru.sahlob.persistance.tour.VisitedPlace;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public abstract class TourGenerator {

    public static Tour generateOptionalTour() {
        var availableWeekDays = new HashSet<Integer>();
        availableWeekDays.add(1);
        availableWeekDays.add(2);
        availableWeekDays.add(3);

        var visitedPlace = new VisitedPlace();
        visitedPlace.setId(0);
        visitedPlace.setName("Visited place name");
        visitedPlace.setDuration(3);
        visitedPlace.setDescription("Desctiption of visited place");

        var tour = Tour.builder()
                .id(23)
                .imagesId(Arrays.asList(1, 2, 3))
                .name("tourName")
                .smallDescription("small description")
                .description("description")
                .economyPrice(100)
                .groupPrice(200)
                .premiumPrice(300)
                .coolness(99)
                .availableWeekDays(availableWeekDays)
                .duration(3)
                .beginningTourHour(12)
                .beginningTourMinutes(23)
                .likedByPerson(true)
                .visitedPlaces(Collections.singletonList(new VisitedPlace()))
                .build();
        return tour;
    }
}
