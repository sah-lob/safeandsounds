package ru.sahlob;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBImagesRepository extends CrudRepository<Image, Integer> {
}
