package org.iclub.model;

import java.net.URLEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.iclub.calendar.CalendarEvent;

@Entity
@Table(name = "weekly_event")
public class WeeklyEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = false, length = 50)
    private String name;

    @Column(name = "description", nullable = true, unique = false, length = 250)
    private String description;

    @Column(name = "url", nullable = true, unique = false, length = 50)
    private String url;

    @Column(name = "address", nullable = true, unique = false, length = 250)
    private String address;

    @Column(name = "day_of_week", nullable = false, updatable = true)
    private Integer dayOfWeek;

    @Column(name = "time_of_day", nullable = false, updatable = true)
    private java.sql.Time time;

    public CalendarEvent getCalendarEvent() {
        CalendarEvent ce = new CalendarEvent();
        ce.setName(name);
        ce.setDescription(description);
        ce.setUrl(url);
        ce.setAddress(address);
        ce.setHour(getHours());
        ce.setMinute(getMinutes());
        ce.setPm(isPm());
        ce.setWeekly(true);

        return ce;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEncodedUrl() {
        return URLEncoder.encode(url);
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

    public boolean isWeekly() {
        return dayOfWeek == null ? false : true;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public java.sql.Time getTime() {
        return time;
    }

    public void setTime(java.sql.Time time) {
        this.time = time;
    }

    public int getHours() {
        if (time == null) {
            return 0;
        } else {
            if (time.getHours() == 0) {
                return 12;
            } else if(time.getHours() > 12) {
                return time.getHours() - 12;
            } else {
                return time.getHours();
            }
        }
    }

    public int getMinutes() {
        return time == null ? 0 : time.getMinutes();
    }

    public boolean isPm() {
        return time == null ? false : time.getHours() >= 12;
    }
}
