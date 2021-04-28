package ru.sahlob.db.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sahlob.persistance.Order;

@Repository
public interface DBOrdersRepository extends CrudRepository<Order, Integer> {
}
