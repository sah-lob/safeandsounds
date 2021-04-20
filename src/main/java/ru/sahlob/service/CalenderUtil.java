package ru.sahlob.service;

import ru.sahlob.persistance.calender.CalenderAnswer;
import ru.sahlob.persistance.calender.Day;
import ru.sahlob.persistance.calender.Month;
import ru.sahlob.persistance.tour.Tour;

import java.util.Calendar;
import java.util.Date;

public class CalenderUtil {

    public static Month getMonth(int currentMonth, int currentYear, Tour tour) {
        var date = new Date();
        var cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.YEAR, currentYear);
        cal.set(Calendar.MONTH, currentMonth);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        var firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        var daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        var k = firstDayOfWeek;
        if (k < 2) {
            k += 8;
        }
        k -= 2;
        var month = new Month();
        month.addNewWeek();
        var flag = true;
        for (var i = 0; i < daysInMonth; i++) {
            if (k == 7) {
                month.addNewWeek();
                k = 0;
            }
            if (i == 0 && k != 0 && flag) {
                var cal1 = Calendar.getInstance();
                cal1.setTime(date);
                cal.add(Calendar.MONTH, -1);
                var daysInMonth1 = cal1.getActualMaximum(Calendar.DAY_OF_MONTH);
                var weekDay = 0;
                for (var j = k; j > 0; j--) {
                    month.addNewDay(addDay(currentMonth, currentYear, weekDay, daysInMonth1, tour, true));
                    weekDay++;
                }
                flag = false;
                i--;
            } else {
                month.addNewDay(addDay(currentMonth, currentYear, k, i + 1, tour, false));
                k++;
            }
        }

        if (month.getLastWeek().getDays().size() != 7) {
            var week = month.getLastWeek();
            var restDays = 7 - week.getDays().size();
            var count = week.getDays().size();
            for (int i = 0; i < restDays; i++) {
                week.add(addDay(currentMonth + 1, currentYear,  count, i + 1, tour, false));
                count++;
            }
        }
        return month;
    }

    public static CalenderAnswer getCalenderAnswer(int currentMonth, int currentYear, Tour tour) {
        var calenderAnswer = new CalenderAnswer();
        if (currentYear == -99) {
            currentYear = Calendar.getInstance().get(Calendar.YEAR);
            calenderAnswer.setCurrentYear(currentYear);
        }
        if (currentMonth == -99) {
            currentMonth = Calendar.getInstance().get(Calendar.MONTH);
            calenderAnswer.setCurrentMonth(currentMonth);
        }
        if (currentMonth > 11) {
            currentMonth = 0;
            calenderAnswer.setCurrentMonth(currentMonth);
            currentYear += 1;
            calenderAnswer.setCurrentYear(currentYear);
        }
        if (currentMonth < 0) {
            currentMonth = 11;
            calenderAnswer.setCurrentMonth(currentMonth);
            currentYear -= 1;
            calenderAnswer.setCurrentYear(currentYear);
        }
        calenderAnswer.setCurrentMonthName(getMonth(currentMonth));
        calenderAnswer.setCurrentMonth(currentMonth);
        calenderAnswer.setCurrentYear(currentYear);
        calenderAnswer.setMonth(getMonth(currentMonth, currentYear, tour));
        return calenderAnswer;
    }

    public static String getMonth(int month) {
        String[] monthNames = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"};
        return monthNames[month];
    }

    public static int getNumOfMonth(String month) {
        switch (month) {
            case ("January"):
                return 0;
            case ("February"):
                return 1;
            case ("March"):
                return 2;
            case ("April"):
                return 3;
            case ("May"):
                return 4;
            case ("June"):
                return 5;
            case ("July"):
                return 6;
            case ("August"):
                return 7;
            case ("September"):
                return 8;
            case ("October"):
                return 9;
            case ("November"):
                return 10;
            case ("December"):
                return 11;
            default:
                return -1;
        }
    }

    private static Day addDay(int currentMonth,
                              int currentYear,
                              int weekDay,
                              int dayInMonth, Tour tour, boolean lastMonth) {

        var availableWeekDays = tour.getAvailableWeekDays();
        var nowMonth = Calendar.getInstance().get(Calendar.MONTH);
        var nowYear = Calendar.getInstance().get(Calendar.YEAR);
        var nowDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        var lastDay = false;
        var isToday = false;
        if (nowYear == currentYear && nowMonth == currentMonth) {
            if (lastMonth) {
                lastDay = true;
            }
            if (nowDay > dayInMonth) {
                lastDay = true;
            }
            if (nowDay == dayInMonth) {
                isToday = true;
            }
        }
        var availableWeekDay = !lastDay && !isToday && availableWeekDays.contains(weekDay);
        return new Day(dayInMonth, weekDay, lastDay, isToday,availableWeekDay, tour.getDuration());
    }
}
