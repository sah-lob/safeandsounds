package ru.sahlob.service.calender;

import lombok.Data;
import ru.sahlob.db.TourStorage;
import ru.sahlob.persistance.calender.CalenderAnswer;
import ru.sahlob.persistance.calender.CalenderInput;

import java.util.Calendar;

import static ru.sahlob.service.calender.GeneralCalenderUtils.getMonthByNum;
import static ru.sahlob.service.calender.GeneralCalenderUtils.getNumOfMonthByTitle;

@Data
public class CalenderAnswerUtil {

    private final static CalenderUtil calenderUtil = new CalenderUtil();

    public static CalenderAnswer getCalenderAnswer(CalenderInput calenderInput, TourStorage tourStorage) {
        var calenderAnswer = new CalenderAnswer();
        var newCurrentMonth = getNumOfMonthByTitle(calenderInput.getCurrentMonth()) + calenderInput.getDirection();
        var intCurrentYear = calenderInput
                .getCurrentYear()
                .equals("") ? Calendar.getInstance().get(Calendar.YEAR) : Integer.parseInt(calenderInput.getCurrentYear());

        if (newCurrentMonth > 11) {
            newCurrentMonth = 0;
            intCurrentYear += 1;
        }
        if (newCurrentMonth < 0) {
            newCurrentMonth = 11;
            intCurrentYear -= 1;
        }
        calenderAnswer.setCurrentMonthName(getMonthByNum(newCurrentMonth));
        calenderAnswer.setCurrentMonth(newCurrentMonth);
        calenderAnswer.setCurrentYear(intCurrentYear);
        calenderAnswer.setMonth(calenderUtil.getMonthByYearAndMonthNum(
                newCurrentMonth,
                intCurrentYear,
                tourStorage
                        .findTourById(calenderInput.getTourId())));
        return calenderAnswer;
    }
}
