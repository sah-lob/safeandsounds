package ru.sahlob.db.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.sahlob.persistance.tour.Tour;

import java.util.Set;

@Repository
public interface DBToursRepository extends PagingAndSortingRepository<Tour, Integer> {

    Tour findFirstById(int id);

    @Query("SELECT c FROM Tour c WHERE"
            + "((:toursId) is null or c.id in :toursId)"
            + "and (:durationFrom is null or  c.duration >= :durationFrom)"
            + "and (:durationTo is null or  c.duration <= :durationTo)"
            + "and (:hourFrom is null or  c.beginningTourHour >= :hourFrom)"
            + "and (:hourTo is null or  c.beginningTourHour <= :hourTo)"
            + "and (:priceFrom is null or  c.economyPrice >= :priceFrom)"
            + "and (:priceTo is null or  c.economyPrice <= :priceTo)")
    Page<Tour> findAllWithFilters(
            Set<Integer> toursId,
            Integer durationFrom,
            Integer durationTo,
            Integer hourFrom,
            Integer hourTo,
            Integer priceFrom,
            Integer priceTo,
            Pageable pageable);
}
