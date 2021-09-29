package ru.sahlob.persistance.order.utils;

import org.springframework.stereotype.Component;
import ru.sahlob.persistance.client.Client;
import ru.sahlob.persistance.order.InputOrder;
import ru.sahlob.persistance.order.Order;
import ru.sahlob.persistance.order.PerformCommunicationMethod;
import ru.sahlob.persistance.order.TourType;
import ru.sahlob.persistance.tour.Tour;

@Component
public class InputTourUtils {

    public static Integer getOrderPriceFromWithTypeTour(TourType tourType, Tour tour) {
        switch (tourType) {
            case Эконом:
                return tour.getEconomyPrice();
            case Премиум:
                return tour.getPremiumPrice();
            default:
                return tour.getGroupPrice();
        }
    }
}
