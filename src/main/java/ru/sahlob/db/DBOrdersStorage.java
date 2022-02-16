package ru.sahlob.db;

import lombok.Data;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Component;
import ru.sahlob.db.interfaces.DBOrdersRepository;
import ru.sahlob.persistance.order.Order;

@Data
@Component
public class DBOrdersStorage {

    private final DBOrdersRepository dbOrdersRepository;

    public Order saveOrder(Order order) {
        return dbOrdersRepository.save(order);
    }

    public Order getOrderById(int id) {
        return dbOrdersRepository.findById(id);
    }

    public Order getOrderByUuid(String uuid) {
        return dbOrdersRepository.findByUuid(uuid);
    }

    public Order getOrderByUuid2(String uuid) {
        return dbOrdersRepository.findByUuid2(uuid);
    }
}
