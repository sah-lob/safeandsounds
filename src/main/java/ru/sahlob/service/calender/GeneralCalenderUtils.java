package ru.sahlob.service.calender;

import java.util.Calendar;

public class GeneralCalenderUtils {

    public static String getMonthByNum(int month) {
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

        if (month == 12) {
            month = 0;
        } else if (month == -1) {
            month = 11;
        }
        return monthNames[month];
    }

    public static int getNumOfMonthByTitle(String month) {
        if (month.equals("")) {
            return Calendar.getInstance().get(Calendar.MONTH);
        }
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
}
