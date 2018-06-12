package com.grabarski.mateusz.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Mateusz Grabarski on 12.06.2018.
 */
public class MyDate {

    private LocalDate localDate;

    public MyDate(String date, String dateFormat) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        this.localDate = LocalDate.parse(date, dateTimeFormatter);

        String createdDate = format(dateFormat);

        if (!date.equals(createdDate)) {
            throw new IllegalArgumentException("Date are not match with format");
        }
    }

    public LocalDate addDays(int days) {
        localDate = localDate.plusDays(days);
        return localDate;
    }

    public LocalDate subtractDays(int days) {
        localDate = localDate.minusDays(days);
        return localDate;
    }

    public String format(String dateFormat) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        return localDate.format(dateTimeFormatter);
    }

    public LocalDate getCurrentDate() {
        return localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyDate myDate = (MyDate) o;

        return localDate != null ? localDate.equals(myDate.localDate) : myDate.localDate == null;
    }

    @Override
    public int hashCode() {
        return localDate != null ? localDate.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "localDate=" + localDate +
                '}';
    }
}