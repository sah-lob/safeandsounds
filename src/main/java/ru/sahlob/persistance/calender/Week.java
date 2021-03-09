package ru.sahlob.persistance.calender;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Week {
    private ArrayList<Day> days = new ArrayList<>();

    public void add(Day day) {
        days.add(day);
    }
}
