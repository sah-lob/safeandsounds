package ru.sahlob.persistance.order.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.sahlob.persistance.order.NewInputOrder;
import ru.sahlob.persistance.order.Order;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderUtils {

    public static Order newInputOrderToOrder(NewInputOrder newInputOrder) {
        var order = new Order();
        order.setTourType(newInputOrder.getTourType());
        order.setTourDate(newInputOrder.getTourDate());
        order.setTourId(newInputOrder.getTourId());
        return order;
    }
}
