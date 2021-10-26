package ru.sahlob.db;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.sahlob.db.interfaces.DBImagesRepository;
import ru.sahlob.persistance.Image;


@Data
@Component
public class DBImagesStorage {

    private final DBImagesRepository dbImagesRepository;

    public Image findById(Integer imageId) {
        return dbImagesRepository.findFirstById(imageId);
    }

    public void saveImage(Image image) {
        dbImagesRepository.save(image);
    }

    public void deleteById(Integer imageId) {
        dbImagesRepository.deleteById(imageId);
    }
}
