package org.iclub.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.iclub.model.EventForm;
import org.iclub.service.EventService;
import org.iclub.validator.EventValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ConditionalOnWebApplication
public class AdminEventController {

    private EventService eventService;
    private EventValidator eventValidator;

    @Autowired
    public AdminEventController(EventService eventService, EventValidator eventValidator) {
        this.eventService = eventService;
        this.eventValidator = eventValidator;
    }

    @RequestMapping(value ="/admin/events/delete", method = RequestMethod.GET)
    public String deleteEvent(@RequestParam("id") String id) {
        eventService.deleteEvent(new Long(id));
        return "redirect:/admin/events?deleted=true";
    }

    @RequestMapping(value ="/admin/events/weekly/delete", method = RequestMethod.GET)
    public String deleteWeeklyEvent(@RequestParam("id") String id) {
        eventService.deleteWeeklyEvent(new Long(id));
        return "redirect:/admin/events?deleted=true";
    }

    @RequestMapping(value = "/admin/events", method = RequestMethod.GET)
    public ModelAndView getAdminImagesPage(HttpServletRequest request) {
        final ModelAndView mv = new ModelAndView("admin_events");
        mv.addObject("days", eventService.getWeeklyDays(7));
        mv.addObject("events", eventService.getEventDays());

        if("true".equals(request.getParameter("added"))) {
            mv.addObject("message", "Event Added");
        }
        if("true".equals(request.getParameter("deleted"))) {
            mv.addObject("message", "Event Deleted");
        }

        return mv;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(eventValidator);
    }

    @RequestMapping(value = "/admin/events", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") EventForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin_events";
        }

        try {
            if (form.isWeekly()) {
                eventService.saveWeeklyEvent(form.toWeeklyEvent());
            } else {
                eventService.saveEvent(form.toEvent());
            }
        } catch (Exception e) {
            return "admin_events";
        }

        return "redirect:/admin/events?added=true";
    }
}
