package ru.sahlob.persistance.calender;

import lombok.Data;

@Data
public class CalenderInput {
    private String currentMonth;
    private int direction;
    private String currentYear;
    private int tourId;
}
