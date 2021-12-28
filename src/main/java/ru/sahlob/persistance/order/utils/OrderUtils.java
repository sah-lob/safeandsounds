package ru.sahlob.persistance.order.utils;

import ru.sahlob.persistance.order.NewInputOrder;
import ru.sahlob.persistance.order.Order;

public class OrderUtils {

    public static Order newInputOrderToOrder(NewInputOrder newInputOrder) {
        var order = new Order();
        order.setTourType(newInputOrder.getTourType());
        order.setTourDate(newInputOrder.getTourDate());
        order.setTourId(newInputOrder.getTourId());
        return order;
    }
}
