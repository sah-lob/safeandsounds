package ru.sahlob.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sahlob.persistance.Image;

import java.util.List;

@Repository
public interface DBImagesRepository extends CrudRepository<Image, Integer> {
    List<Image> findAll();
    Image findAllById(Integer id);
}
