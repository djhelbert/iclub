package org.iclub.service;

import java.util.Calendar;
import java.util.Date;
import org.iclub.model.Event;
import org.iclub.model.WeeklyEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventServiceTest {

    @Autowired
    private EventService eventService;

    @Test
    public void testWeeklyEvents() {
        eventService.saveWeeklyEvent(getWeeklyEvent());
        assert 1 == eventService.findAllWeeklyEvents().size();
    }

    @Test
    public void testEvents() {
        eventService.saveEvent(getEvent());
        assert 1 == eventService.findAllEvents().size();

        Calendar start = Calendar.getInstance();
        start.add(Calendar.DATE, -1);

        Calendar end = Calendar.getInstance();
        end.add(Calendar.DATE, 3);

        assert 1 == eventService.findEvents(start.getTime(), end.getTime()).size();
    }

    private Event getEvent() {
        Event we = new Event();
        we.setTimestamp(new Date());
        we.setName("Sunday Party");
        we.setDescription("Hey bud let's party!");
        we.setAddress("Beverly Hills, CA 90210");
        we.setUrl("http://www.evite.com");

        return we;
    }

    private WeeklyEvent getWeeklyEvent() {
        WeeklyEvent we = new WeeklyEvent();
        we.setDayOfWeek(Calendar.SUNDAY);
        we.setName("Sunday Fun Day");
        we.setDescription("No work today let's play.");
        we.setAddress("Beverly Hills, CA 90210");
        we.setUrl("http://www.yahoo.com");

        return we;
    }
}
