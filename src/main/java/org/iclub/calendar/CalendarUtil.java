package org.iclub.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarUtil {

    /**
     * Get Calendar Days
     * 
     * @param days
     * @return
     */
    public static List<CalendarDay> getCalendarDays(int days) {
        final List<CalendarDay> list = new ArrayList<>();
        final Calendar cal = Calendar.getInstance();

        while (cal.get(Calendar.DAY_OF_WEEK) > Calendar.SUNDAY) {
            cal.add(Calendar.DATE, -1);
        }

        for (int i=Calendar.SUNDAY; i <= days; i++) {
            list.add(new CalendarDay(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR), cal.get(Calendar.DAY_OF_WEEK)));
            cal.add(Calendar.DATE, 1);
        }

        return list;
    }
}
