package ru.sahlob.persistance.order.utils;

import org.junit.jupiter.api.Test;
import ru.sahlob.persistance.order.NewInputOrder;
import ru.sahlob.persistance.order.TourType;

import static org.junit.jupiter.api.Assertions.*;

class OrderUtilsTest {

    @Test
    void newInputOrderToOrder() {
        NewInputOrder newInputOrder = new NewInputOrder();
        int tourId= 4;
        TourType tourType = TourType.Премиум;
        String tourDate = "tourDate";
        newInputOrder.setTourId(tourId);
        newInputOrder.setTourType(tourType);
        newInputOrder.setTourDate(tourDate);
        var order = OrderUtils.newInputOrderToOrder(newInputOrder);
        assertEquals(tourId, order.getTourId());
        assertEquals(tourDate, order.getTourDate());
        assertEquals(tourType, order.getTourType());
    }
}