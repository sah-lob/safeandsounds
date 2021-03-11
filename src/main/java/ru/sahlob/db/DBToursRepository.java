package ru.sahlob.db;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.sahlob.persistance.tour.Tour;

import java.util.List;

@Repository
public interface DBToursRepository extends PagingAndSortingRepository<Tour, Integer> {
    List<Tour> findAll();
}
