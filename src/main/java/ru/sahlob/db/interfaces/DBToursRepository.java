package ru.sahlob.db.interfaces;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.sahlob.persistance.tour.Tour;

import java.util.List;

@Repository
public interface DBToursRepository extends PagingAndSortingRepository<Tour, Integer> {
    List<Tour> findAll();
    Tour findFirstById(int id);
}
