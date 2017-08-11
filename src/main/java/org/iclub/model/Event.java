package org.iclub.model;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.iclub.calendar.CalendarEvent;

@Entity
@Table(name = "event", indexes = @Index(name = "event_index_timestamp", columnList="timestamp", unique = false))
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = false, length = 50)
    private String name;

    @Column(name = "description", nullable = true, unique = false, length = 250)
    private String description;

    @Column(name = "url", nullable = true, unique = false, length = 250)
    private String url;

    @Column(name = "address", nullable = true, unique = false, length = 250)
    private String address;

    @Column(name = "timestamp", nullable = true, updatable = true)
    private Date timestamp;

    public CalendarEvent getCalendarEvent() {
        CalendarEvent ce = new CalendarEvent();
        ce.setId(id);
        ce.setName(name);
        ce.setDescription(description);
        ce.setUrl(url);
        ce.setAddress(address);
        ce.setHour(getHours());
        ce.setMinute(getMinutes());
        ce.setPm(isPm());
        ce.setWeekly(false);

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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    private Calendar getCalendar() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp.getTime());
        return c;
    }

    public int getDayOfWeek() {
        return getCalendar().get(Calendar.DAY_OF_WEEK);
    }

    public int getDay() {
        return getCalendar().get(Calendar.DAY_OF_MONTH);
    }

    public int getMonth() {
        return getCalendar().get(Calendar.MONTH) + 1;
    }

    public int getYear() {
        return getCalendar().get(Calendar.YEAR);
    }

    public int getHours() {
        if (timestamp == null) {
            return 0;
        } else {
            if (timestamp.getHours() == 0) {
                return 12;
            } else if(timestamp.getHours() > 12) {
                return timestamp.getHours() - 12;
            } else {
                return timestamp.getHours();
            }
        }
    }

    public int getMinutes() {
        return timestamp == null ? 0 : timestamp.getMinutes();
    }

    public boolean isPm() {
        return timestamp == null ? false : timestamp.getHours() >= 12;
    }

    @Override
    public String toString() {
        return "{" + getName() + " " + getHours() + ":" + getMinutes()  + " " + getDay() + " " + getMonth() + " " + getYear() + "}";
    }
}
