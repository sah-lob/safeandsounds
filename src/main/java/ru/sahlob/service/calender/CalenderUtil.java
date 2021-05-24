package ru.sahlob.service.calender;

import ru.sahlob.persistance.calender.Month;
import ru.sahlob.persistance.tour.Tour;

import java.util.Calendar;
import java.util.Date;


public class CalenderUtil {

    public Month getMonthByYearAndMonthNum(int currentMonth, int currentYear, Tour tour) {
        var date = new Date();
        var cal = createCalendarWithCurrentYearMonthAndDate(date, currentYear, currentMonth);
        var firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        var daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        var numDayOfWeek = getNumDayOfWeek(firstDayOfWeek);
        return createMonth(daysInMonth, numDayOfWeek, date, cal, currentMonth, currentYear, tour);
    }

    private static Month createMonth(int daysInMonth,
                                     int numDayOfWeek,
                                     Date date,
                                     Calendar cal,
                                     int currentMonth,
                                     int currentYear,
                                     Tour tour) {

        var month = new Month();
        addDaysToLastMonth(month, date, cal, numDayOfWeek, currentMonth, currentYear, tour);
        addDaysToCurrentMonth(month, tour, numDayOfWeek, daysInMonth, currentMonth, currentYear);
        addDaysForNextMonth(month, currentMonth, currentYear, tour);
        return month;
    }


    private static int checkOrCreateNewWeekInMonth(int numDayOfWeek, Month month) {
        if (numDayOfWeek == 7) {
            month.addNewWeek();
            numDayOfWeek = 0;
        }
        return numDayOfWeek;
    }

    /**
     * Добавляем дни прошлему месяцу
     */
    private static void addDaysToLastMonth(Month month, Date date, Calendar cal, int numDayOfWeek, int currentMonth, int currentYear, Tour tour) {
        var cal1 = Calendar.getInstance();
        cal1.setTime(date);
        cal.add(Calendar.MONTH, -1);
        var daysInMonth1 = cal1.getActualMaximum(Calendar.DAY_OF_MONTH);
        var weekDay = 0;
        /**
         * Прошлый месяц.
         */
        for (var j = numDayOfWeek; j > 0; j--) {
            month.addNewDay(
                    AddDayUtil.createMonthDay(
                            currentMonth - 1,
                            currentMonth,
                            currentYear,
                            weekDay,
                            daysInMonth1 - (j - 1),
                            tour,
                            true));
            weekDay++;
        }
    }

    /**
     * Добавляем дни текущему месяцу
     */
    private static void addDaysToCurrentMonth(Month month, Tour tour, int numDayOfWeek, int daysInMonth, int currentMonth, int currentYear) {
        for (var i = 0; i < daysInMonth; i++) {
            numDayOfWeek = checkOrCreateNewWeekInMonth(numDayOfWeek, month);
            month.addNewDay(
                    AddDayUtil.createMonthDay(
                            currentMonth,
                            currentMonth,
                            currentYear,
                            numDayOfWeek,
                            i + 1,
                            tour,
                            false));
            numDayOfWeek++;
        }
    }

    /**
     * Добавляем дни следующему месяцу
     */
    private static void addDaysForNextMonth(Month month, int currentMonth, int currentYear, Tour tour) {
        if (month.getLastWeek().getDays().size() != 7) {
            var week = month.getLastWeek();
            var restDays = 7 - week.getDays().size();
            var count = week.getDays().size();
            for (int i = 0; i < restDays; i++) {
                week.add(
                        AddDayUtil.createMonthDay(
                                currentMonth + 1,
                                currentMonth,
                                currentYear,
                                count,
                                i + 1,
                                tour,
                                false));
                count++;
            }
        }
    }

    private static Calendar createCalendarWithCurrentYearMonthAndDate(Date date, int currentYear, int currentMonth) {
        var cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.YEAR, currentYear);
        cal.set(Calendar.MONTH, currentMonth);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal;
    }

    private static int getNumDayOfWeek(int firstDayOfWeek) {
        var numDayOfWeek = firstDayOfWeek;
        if (numDayOfWeek < 2) {
            numDayOfWeek += 8;
        }
        numDayOfWeek -= 2;
        return numDayOfWeek;
    }
}

