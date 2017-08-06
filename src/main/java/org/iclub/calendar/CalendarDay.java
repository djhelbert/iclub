package org.iclub.calendar;

import java.util.ArrayList;
import java.util.List;

public class CalendarDay {

    private Integer year;
    private Integer month;
    private Integer day;
    private Integer dayOfWeek;
    private List<CalendarEvent> events = new ArrayList<>();

    public CalendarDay() {
    }

    public CalendarDay(Integer day, Integer month, Integer year, Integer dayOfWeek) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public final String getMonthLabel() {
        String monthString;
        switch (month) {
        case 1:
            monthString = "January";
            break;
        case 2:
            monthString = "February";
            break;
        case 3:
            monthString = "March";
            break;
        case 4:
            monthString = "April";
            break;
        case 5:
            monthString = "May";
            break;
        case 6:
            monthString = "June";
            break;
        case 7:
            monthString = "July";
            break;
        case 8:
            monthString = "August";
            break;
        case 9:
            monthString = "September";
            break;
        case 10:
            monthString = "October";
            break;
        case 11:
            monthString = "November";
            break;
        case 12:
            monthString = "December";
            break;
        default:
            monthString = "";
            break;
        }
        return monthString;
    }

    public Integer getDay() {
        return day;
    }

    public final String getDayLabel() {
        String dayString;
        switch (dayOfWeek) {
        case 1:
            dayString = "Sunday";
            break;
        case 2:
            dayString = "Monday";
            break;
        case 3:
            dayString = "Tuesday";
            break;
        case 4:
            dayString = "Wednesday";
            break;
        case 5:
            dayString = "Thursday";
            break;
        case 6:
            dayString = "Friday";
            break;
        case 7:
            dayString = "Saturday";
            break;
        default:
            dayString = "";
            break;
        }
        return dayString;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public boolean hasEvents() {
        return events == null ? false : events.size() > 0;
    }

    public int getEventsSize() {
        return events.size();
    }

    public List<CalendarEvent> getEvents() {
        return events;
    }

    public void setEvents(List<CalendarEvent> events) {
        this.events = events;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "{" + getDayLabel() + " " + getMonthLabel() + " " + day + ", " + year + "}";
    }
}
