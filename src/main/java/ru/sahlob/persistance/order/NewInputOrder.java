package ru.sahlob.persistance.order;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewInputOrder {
    private TourType tourType;
    private String tourDate;
    private int tourId;
}
