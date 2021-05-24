package ru.sahlob.service.calender;

import lombok.Data;
import ru.sahlob.persistance.calender.CalenderAnswer;
import ru.sahlob.persistance.tour.Tour;

import java.util.Calendar;

import static ru.sahlob.service.calender.GeneralCalenderUtils.getMonthByNum;

@Data
public class CalenderAnswerUtil {

    private final static CalenderUtil calenderUtil = new CalenderUtil();

    public static CalenderAnswer getCalenderAnswer(int currentMonth, int currentYear, Tour tour) {
        var calenderAnswer = new CalenderAnswer();
        if (currentYear == -99) {
            currentYear = Calendar.getInstance().get(Calendar.YEAR);
        }
        if (currentMonth == -99) {
            currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        }
        if (currentMonth > 11) {
            currentMonth = 0;
            currentYear += 1;
        }
        if (currentMonth < 0) {
            currentMonth = 11;
            currentYear -= 1;
        }
        calenderAnswer.setCurrentMonthName(getMonthByNum(currentMonth));
        calenderAnswer.setCurrentMonth(currentMonth);
        calenderAnswer.setCurrentYear(currentYear);
        calenderAnswer.setMonth(calenderUtil.getMonthByYearAndMonthNum(currentMonth, currentYear, tour));
        return calenderAnswer;
    }
}
