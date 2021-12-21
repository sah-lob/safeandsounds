package ru.sahlob.persistance.calender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DayTest {

    private Day day;
    private final int num = 1;
    private final int weekDayNum = 2;
    private final boolean lastDay = false;
    private final boolean today = true;
    private final boolean availableTour = false;
    private final String duration = "2 часа";
    private final String beginningTour = "10:30";
    private final int monthNum = 3;
    private final String month = "August";

    @BeforeEach
    public void createDay() {
        day = new Day(num,
                weekDayNum,
                lastDay,
                today,
                availableTour,
                duration,
                beginningTour,
                monthNum,
                month);
    }


    @Test
    void getNum() {
        assertEquals(num, day.getNum());
    }

    @Test
    void getWeekDayNum() {
        assertEquals(weekDayNum, day.getWeekDayNum());
    }

    @Test
    void isLastDay() {
        assertFalse(day.isLastDay());
    }

    @Test
    void isToday() {
        assertTrue(day.isToday());
    }

    @Test
    void isAvailableTour() {
        assertFalse(day.isAvailableTour());
    }

    @Test
    void getDuration() {
        assertEquals(day.getDuration(), duration);
    }

    @Test
    void getBeginningTour() {
        assertEquals(day.getBeginningTour(), beginningTour);
    }

    @Test
    void getMonthNum() {
        assertEquals(day.getMonthNum(), monthNum);
    }

    @Test
    void getMonth() {
        assertEquals(day.getMonth(), month);
    }

    @Test
    void setNum() {
        int newNum = 43;
        day.setNum(newNum);
        assertEquals(newNum, day.getNum());
    }

    @Test
    void setWeekDayNum() {
        int newWeekDayNum = 6;
        day.setWeekDayNum(newWeekDayNum);
        assertEquals(newWeekDayNum, day.getWeekDayNum());
    }

    @Test
    void setLastDay() {
    }

    @Test
    void setToday() {
    }

    @Test
    void setAvailableTour() {
    }

    @Test
    void setDuration() {
    }

    @Test
    void setBeginningTour() {
    }

    @Test
    void setMonthNum() {
    }

    @Test
    void setMonth() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void canEqual() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}