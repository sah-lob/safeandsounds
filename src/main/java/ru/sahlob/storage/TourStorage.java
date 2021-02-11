package ru.sahlob.storage;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.sahlob.db.DBImagesRepository;
import ru.sahlob.db.DBToursRepository;
import ru.sahlob.persistance.Image;
import ru.sahlob.persistance.InputTour;
import ru.sahlob.persistance.Tour;

import java.io.IOException;

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
                        inputTour.getPrice(), inputTour.getCoolness()));

        Pageable firstPageWithTwoElements = PageRequest.of(0, 10, Sort.by("coolness").descending());
        Page<Tour> allProducts = dbToursRepository.findAll(firstPageWithTwoElements);
        allProducts.getTotalElements();
        allProducts.getTotalPages();
    }

    public Tour findTourById(int id) {
        return dbToursRepository
                .findById(id)
                .get();
    }

    public Page<Tour> findTours(Pageable pageable) {
        return dbToursRepository.findAll(pageable);
    }
}
