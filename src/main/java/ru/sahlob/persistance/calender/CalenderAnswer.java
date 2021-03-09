package ru.sahlob.persistance.calender;

import lombok.Data;

@Data
public class CalenderAnswer {
    private int currentYear;
    private int currentMonth;
    private boolean backMonth;
    private String currentMonthName;
    private Month month;
}
