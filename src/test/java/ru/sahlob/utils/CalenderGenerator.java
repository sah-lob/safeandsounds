package ru.sahlob.utils;

import ru.sahlob.persistance.calender.CalenderInput;

public abstract class CalenderGenerator {
    public static CalenderInput generateCalenderInput() {
        return CalenderInput
                .builder()
                .currentMonth("Marth")
                .currentYear("2021")
                .direction(1)
                .tourId(32)
                .build();
    }
}
