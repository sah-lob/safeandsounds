package ru.sahlob.persistance.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewInputOrderTest {

    private NewInputOrder newInputOrder;
    String tourDate = "tour date";
    TourType tourType = TourType.Премиум;
    int tourId = 3;

    @BeforeEach
    public void createNewInputOrder() {
        newInputOrder = new NewInputOrder();
        newInputOrder.setTourType(tourType);
        newInputOrder.setTourDate(tourDate);
        newInputOrder.setTourId(tourId);
    }

    @Test
    void getTourType() {
        assertEquals(tourType, newInputOrder.getTourType());
    }

    @Test
    void getTourDate() {
        assertEquals(tourDate, newInputOrder.getTourDate());
    }

    @Test
    void getTourId() {
        assertEquals(tourId, newInputOrder.getTourId());
    }

    @Test
    void setTourType() {
        newInputOrder.setTourType(TourType.Групповая);
        assertEquals(TourType.Групповая, newInputOrder.getTourType());
    }

    @Test
    void setTourDate() {
        newInputOrder.setTourDate("sa");
        assertEquals("sa", newInputOrder.getTourDate());
    }

    @Test
    void setTourId() {
        newInputOrder.setTourId(32);
        assertEquals(32,newInputOrder.getTourId());
    }
}