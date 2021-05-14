package ru.sahlob.db;

import lombok.Data;
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
        return dbOrdersRepository.findById(id).get();
    }

    public Order getOrderByUuid(String uuid) {
        return dbOrdersRepository.findByUuid(uuid);
    }
}
