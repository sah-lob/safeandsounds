package ru.sahlob.service.calender;

import ru.sahlob.persistance.calender.Day;
import ru.sahlob.persistance.tour.Tour;

import java.util.Calendar;

import static ru.sahlob.service.calender.GeneralCalenderUtils.getMonthByNum;

public class AddDayUtil {

    public static Day createMonthDay(int currentMonth,
                                     int showMonth,
                                     int currentYear,
                                     int weekDay,
                                     int dayInMonth,
                                     Tour tour,
                                     boolean lastMonth) {

        var availableWeekDays = tour.getAvailableWeekDays();
        var nowMonth = Calendar.getInstance().get(Calendar.MONTH);
        var nowYear = Calendar.getInstance().get(Calendar.YEAR);
        var nowDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        var lastDay = false;
        var isToday = false;
        if (nowYear == currentYear && nowMonth >= currentMonth) {
            lastDay = hasTheDayPassed(
                    lastMonth,
                    nowMonth,
                    showMonth,
                    currentMonth,
                    nowDay,
                    dayInMonth);
            isToday = isToday(nowDay, dayInMonth);
        }
        var availableWeekDay = !lastDay && !isToday && availableWeekDays.contains(weekDay);
        return new Day(
                dayInMonth,
                weekDay,
                lastDay,
                isToday,
                availableWeekDay,
                tour.getDuration(),
                currentMonth,
                getMonthByNum(currentMonth));
    }

    private static boolean hasTheDayPassed(boolean lastMonth, int nowMonth, int showMonth, int currentMonth, int nowDay, int dayInMonth) {
        var lastDay = false;
        if (lastMonth) {
            if (nowMonth - showMonth > 1 || currentMonth < nowMonth) {
                lastDay = true;
            }
        }
        if (nowDay > dayInMonth) {
            lastDay = true;
        }
        return lastDay;
    }

    private static boolean isToday(int nowDay, int dayInMonth) {
        return nowDay == dayInMonth;
    }
}
