package ru.sahlob.storage;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import ru.sahlob.db.DBImagesRepository;
import ru.sahlob.db.DBToursRepository;
import ru.sahlob.persistance.Image;
import ru.sahlob.persistance.InputTour;
import ru.sahlob.persistance.tour.Tour;

import java.io.IOException;
import java.util.HashSet;

@Data
@Component
public class TourStorage {

    private final DBImagesRepository dbImagesRepository;
    private final DBToursRepository dbToursRepository;


    public void addTour(InputTour inputTour) throws IOException {
        var image = new Image(inputTour.getFile());
        dbImagesRepository.save(image);
        dbToursRepository.save(
                new Tour(
                        image.getId(),
                        inputTour.getName(),
                        inputTour.getDescription(),
                        inputTour.getPrice(),
                        inputTour.getCoolness(),
                        getAvailableWeekDays(inputTour),
                        inputTour.getDuration()));
//        Pageable firstPageWithTwoElements = PageRequest.of(0, 10, Sort.by("coolness").descending());
//        Page<Tour> allProducts = dbToursRepository.findAll(firstPageWithTwoElements);
//        allProducts.getTotalElements();
//        allProducts.getTotalPages();
    }

    public Tour findTourById(int id) {
        return dbToursRepository
                .findById(id)
                .get();
    }

    public Page<Tour> findTours(Pageable pageable) {
        return dbToursRepository.findAll(pageable);
    }

    public void updateTour(Tour tour) {
        dbToursRepository.save(tour);
    }

    private HashSet<Integer> getAvailableWeekDays(InputTour inputTour) {
        var availableWeekDays = new HashSet<Integer>();
        if (inputTour.getMonday() != null) {
            availableWeekDays.add(0);
        }
        if (inputTour.getTuesday() != null) {
            availableWeekDays.add(1);
        }
        if (inputTour.getWednesday() != null) {
            availableWeekDays.add(2);
        }
        if (inputTour.getThursday() != null) {
            availableWeekDays.add(3);
        }
        if (inputTour.getFriday() != null) {
            availableWeekDays.add(4);
        }
        if (inputTour.getSaturday() != null) {
            availableWeekDays.add(5);
        }
        if (inputTour.getSunday() != null) {
            availableWeekDays.add(6);
        }
        return availableWeekDays;
    }
}
