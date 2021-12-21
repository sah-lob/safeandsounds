package ru.sahlob.service.calender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sahlob.db.TourStorage;
import ru.sahlob.persistance.calender.CalenderInput;
import ru.sahlob.persistance.tour.Tour;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalenderAnswerUtilTest {

    private TourStorage tourStorage;
    private CalenderInput calenderInput;

    @BeforeEach
    void startCalenderAnswerUtil(
            @Mock TourStorage tourStorage,
            @Mock CalenderInput calenderInput) {


        Mockito.lenient().when(calenderInput.getCurrentMonth()).thenReturn("August");
        Mockito.lenient().when(calenderInput.getDirection()).thenReturn(1);
        Mockito.lenient().when(calenderInput.getCurrentYear()).thenReturn("2021");
        Mockito.lenient().when(calenderInput.getTourId()).thenReturn(1);

        Tour tour = new Tour();
        tour.setAvailableWeekDays(Collections.emptySet());
        Mockito.lenient().when(tourStorage.findTourById(1)).thenReturn(tour);
        this.tourStorage = tourStorage;
        this.calenderInput = calenderInput;
    }

    @Test
    void getCalenderAnswer() {
        var ca = CalenderAnswerUtil.getCalenderAnswer(calenderInput, tourStorage);
        assertEquals(2021, ca.getCurrentYear());
        assertEquals(8, ca.getCurrentMonth());
        assertEquals("September", ca.getCurrentMonthName());
    }

    @Test
    void getCalenderAnswer2() {
        Mockito.lenient().when(calenderInput.getCurrentMonth()).thenReturn("December");
        var ca = CalenderAnswerUtil.getCalenderAnswer(calenderInput, tourStorage);
        assertEquals(2022, ca.getCurrentYear());
        assertEquals(0, ca.getCurrentMonth());
        assertEquals("January", ca.getCurrentMonthName());
    }

    @Test
    void getCalenderAnswer3() {
        Mockito.lenient().when(calenderInput.getCurrentMonth()).thenReturn("January");
        Mockito.lenient().when(calenderInput.getDirection()).thenReturn(-1);
        var ca = CalenderAnswerUtil.getCalenderAnswer(calenderInput, tourStorage);
        assertEquals(2020, ca.getCurrentYear());
        assertEquals(11, ca.getCurrentMonth());
        assertEquals("December", ca.getCurrentMonthName());
    }
}