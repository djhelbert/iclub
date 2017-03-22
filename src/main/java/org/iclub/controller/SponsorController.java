package org.iclub.controller;

import org.iclub.service.SponsorService;
import org.iclub.validator.SponsorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ConditionalOnWebApplication
public class SponsorController {

    private final SponsorService sponsorService;
    private final SponsorValidator sponsorValidator;

    @Autowired
    public SponsorController(SponsorService sponsorService, SponsorValidator sponsorValidator) {
        this.sponsorService = sponsorService;
        this.sponsorValidator = sponsorValidator;
    }

    @RequestMapping("/sponsors")
    public ModelAndView getUsersPage() {
        return new ModelAndView("sponsors", "sponsors", sponsorService.findAll());
    }

}
