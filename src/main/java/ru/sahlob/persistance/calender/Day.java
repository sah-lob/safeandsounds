package ru.sahlob.persistance.calender;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Day {
    private int num;
    private int weekDayNum;
    private boolean lastDay;
    private boolean today;
    private boolean availableTour;
    private String duration;
}
