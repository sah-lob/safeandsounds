package ru.sahlob.persistance.calender;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Month {
    private List<Week> weeks = new ArrayList<>();

    public void addNewDay(Day day) {
        if (weeks.isEmpty()) {
            addNewWeek();
        }
        weeks.get(weeks.size() - 1).add(day);
    }

    public void addNewWeek() {
        weeks.add(new Week());
    }

    public Week getLastWeek() {
        return weeks.get(weeks.size() - 1);
    }
}
