package org.iclub.service;

import java.util.Date;
import java.util.List;
import org.iclub.model.Event;
import org.iclub.model.WeeklyEvent;

public interface EventService {

    public List<WeeklyEvent> findAllWeeklyEvents();
    public void deleteWeeklyEvent(Long id);
    public void deleteEvent(Long id);
    public WeeklyEvent saveWeeklyEvent(WeeklyEvent we);
    public Event saveEvent(Event e);
    public List<Event> findEvents(Date start, Date end);
    public List<Event> findAllEvents();

}
