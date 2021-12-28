package ru.sahlob.persistance.order;

import lombok.Data;

@Data
public class NewInputOrder {
    private TourType tourType;
    private String tourDate;
    private int tourId;
}
