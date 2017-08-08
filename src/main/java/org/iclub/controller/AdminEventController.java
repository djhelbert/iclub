package org.iclub.controller;

import org.iclub.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ConditionalOnWebApplication
public class AdminEventController {

    private EventService eventService;

    @Autowired
    public AdminEventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/admin/events", method = RequestMethod.GET)
    public ModelAndView getAdminImagesPage() {
        final ModelAndView mv = new ModelAndView("admin_events");
        mv.addObject("days", eventService.getCalendarDays(7));
        return mv;
    }

}
