package com.grabarski.mateusz.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mateusz Grabarski on 12.06.2018.
 */
public class MyDateTest {

    private MyDate checkingDate;

    @Before
    public void setUp() throws Exception {
        checkingDate = getCorrectDate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenCreatedDateIsNotSameAsConstructorParameter() {
        new MyDate("29-02-2018", "dd-MM-yyyy");
    }

    @Test
    public void shouldAdd7DaysToCurrentDate() {
        checkingDate.addDays(7);
        assertEquals(getCorrectDate().addDays(7), checkingDate.getCurrentDate());
    }

    @Test
    public void shouldGoToNextYearWhenAdd365Days() {
        checkingDate.addDays(365);
        assertEquals(getCorrectDate().addDays(365), checkingDate.getCurrentDate());
    }

    @Test
    public void shouldSubtract7DaysToCurrentDate() {
        checkingDate.subtractDays(7);
        assertEquals(getCorrectDate().subtractDays(7), checkingDate.getCurrentDate());
    }

    @Test
    public void shouldGoBackToPreviousYearWhenSubtract365Days() {
        checkingDate.subtractDays(365);
        assertEquals(getCorrectDate().subtractDays(365), checkingDate.getCurrentDate());
    }

    @Test
    public void shouldReturnDayNumberFromFormatMethod() {
        String formatResult = checkingDate.format("dd");
        assertEquals("29", formatResult);
    }

    @Test
    public void shouldReturnMonthNumberFromFormatMethod() {
        String formatResult = checkingDate.format("MM");
        assertEquals("01", formatResult);
    }

    @Test
    public void shouldReturnYearNumberFromFormatMethod() {
        String formatResult = checkingDate.format("yyyy");
        assertEquals("2018", formatResult);
    }

    private MyDate getCorrectDate() {
        return new MyDate("29-01-2018", "dd-MM-yyyy");
    }
}