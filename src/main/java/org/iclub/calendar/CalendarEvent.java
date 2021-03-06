package org.iclub.calendar;

import java.net.URLEncoder;

public class CalendarEvent {

    private Long id;
    private boolean weekly = false;
    private String name;
    private String description;
    private String url;
    private String address;
    private Integer hour = 0;
    private Integer minute = 0;
    private boolean pm = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isWeekly() {
        return weekly;
    }

    public void setWeekly(boolean weekly) {
        this.weekly = weekly;
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

    public String getMapUrl() {
        return "http://maps.google.com/?q=" + getEncodedAddress();
    }

    public String getEncodedAddress() {
        return URLEncoder.encode(address);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public String getPaddedMinute() {
        return minute < 10 ? "0" + minute : "" + minute;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public boolean isPm() {
        return pm;
    }

    public void setPm(boolean pm) {
        this.pm = pm;
    }

    @Override
    public String toString() {
        return "Event{" + name + " " + hour + " " + minute + "}";
    }
}
