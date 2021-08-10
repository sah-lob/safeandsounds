package ru.sahlob.db.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sahlob.persistance.order.Order;

@Repository
public interface DBOrdersRepository extends CrudRepository<Order, Integer> {
    Order findByUuid(String uuid);

    Order findByUuid2(String uuid2);
}
