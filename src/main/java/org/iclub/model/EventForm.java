package org.iclub.model;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EventForm {

    private String name;
    private String description;
    private String url;
    private String address;
    private String time;
    private Integer dayOfWeek;
    private String date;

    final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-ddHH:mm");;

    public Event toEvent() throws ParseException {
        final Event we = new Event();
        we.setAddress(address);
        we.setDescription(description);
        we.setName(name);
        we.setUrl(url);
        we.setTimestamp(formatter.parse(date+time));

        return we;
    }

    public WeeklyEvent toWeeklyEvent() {
        final WeeklyEvent we = new WeeklyEvent();
        we.setAddress(address);
        we.setDayOfWeek(dayOfWeek);
        we.setDescription(description);
        we.setName(name);
        we.setUrl(url);
        we.setTime(Time.valueOf(time + ":00"));

        return we;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isWeekly() {
        return dayOfWeek == null ? false : dayOfWeek.toString().length() > 0;
    }
}
