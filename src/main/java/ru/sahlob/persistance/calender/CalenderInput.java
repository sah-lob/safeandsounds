package ru.sahlob.persistance.calender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CalenderInput {
    private String currentMonth;
    private int direction;
    private String currentYear;
    private int tourId;
}
