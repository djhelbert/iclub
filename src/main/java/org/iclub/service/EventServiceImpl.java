package org.iclub.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.iclub.model.Event;
import org.iclub.model.WeeklyEvent;
import org.iclub.repository.EventRepository;
import org.iclub.repository.WeeklyEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final WeeklyEventRepository weeklyEventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, WeeklyEventRepository weeklyEventRepository) {
        this.eventRepository = eventRepository;
        this.weeklyEventRepository = weeklyEventRepository;
    }

    public List<WeeklyEvent> findAllWeeklyEvents() {
        return weeklyEventRepository.findAll();
    }

    public void deleteWeeklyEvent(Long id) {
        weeklyEventRepository.delete(id);
    }

    public void deleteEvent(Long id) {
        eventRepository.delete(id);
    }

    public WeeklyEvent saveWeeklyEvent(WeeklyEvent we) {
        return weeklyEventRepository.save(we);
    }

    public Event saveEvent(Event e) {
        return eventRepository.save(e);
    }

    public List<Event> findEvents(Date start, Date end) {
        return eventRepository.findByTimestamp(start, end);
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }
}
