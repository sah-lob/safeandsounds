package ru.sahlob.utils;

import ru.sahlob.persistance.order.*;

public abstract class OrderGenerator {


    public static NewInputOrder generateNewInputOrder() {
        return NewInputOrder.builder()
                .tourDate("data")
                .tourId(3)
                .tourType(TourType.Премиум).build();
    }

    public static Order generateOrder() {
        return Order.builder()
                .id(3)
                .uuid("uuid1")
                .uuid2("uuid2")
                .clientUuid("client uuid")
                .tourType(TourType.Премиум)
                .tourDate("tour data")
                .tourName("tour name")
                .tourPrice(300)
                .comment("order comment").tourId(32)
                .orderStatus(OrderStatus.created)
                .build();
    }

    public static InputOrder generateInputOrder() {
        return InputOrder.builder()
                .orderID(2)
                .clientName("client name")
                .clientPhone("client phone")
                .clientEmail("clientEmail")
                .communicationMethodAdditionalValue("comm method")
                .instagram("insta account")
                .comment("comment").build();
    }


}
