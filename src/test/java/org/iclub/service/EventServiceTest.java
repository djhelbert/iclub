package org.iclub.service;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.iclub.calendar.CalendarDay;
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

        List<CalendarDay> days = eventService.getCalendarDays(7);
        assert days.size() == 7;
        assert days.get(0).getEvents().size() == 1;
        assert days.get(0).getEvents().get(0).isWeekly();
        assert days.get(0).getEvents().get(0).isPm();
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
        we.setTime(Time.valueOf("13:00:00"));

        assert we.isPm() == true;
        assert we.getMinutes() == 0;
        assert we.getHours() == 1;

        return we;
    }
}
