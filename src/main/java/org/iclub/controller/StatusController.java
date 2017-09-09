package org.iclub.controller;

import javax.servlet.http.HttpServletRequest;

import org.iclub.service.BinaryFileService;
import org.iclub.service.EmailService;
import org.iclub.service.SettingService;
import org.iclub.service.SocialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ConditionalOnWebApplication
public class StatusController {

    private SocialService socialService;
    private EmailService emailService;
    private SettingService settingService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    public StatusController(SocialService socialService, BinaryFileService binaryFileService, EmailService emailService, SettingService settingService) {
        this.emailService = emailService;
        this.socialService = socialService;
        this.settingService = settingService;
    }

    @RequestMapping(value = "/admin/status", method = RequestMethod.GET)
    public ModelAndView status(HttpServletRequest request) {
        LOGGER.debug("Obtaining Statuses");

        final ModelAndView mv = new ModelAndView("admin_status");

        try {
            if( socialService.getFacebook() != null ) {
                mv.addObject("facebook", Boolean.TRUE);
            } else {
                mv.addObject("facebook", Boolean.FALSE);
            }
        } catch (Exception err) {
            LOGGER.error("Status", err);
            mv.addObject("facebook", Boolean.FALSE);
        }

        try {
            if( settingService.findSettingByName(SettingService.TITLE).get() != null ) {
                mv.addObject("database", Boolean.TRUE);
            } else {
                mv.addObject("database", Boolean.FALSE);
            }
        } catch (Exception err) {
            LOGGER.error("Status", err);
            mv.addObject("database", Boolean.FALSE);
        }

        try {
            if( emailService.isHealthy() ) {
                mv.addObject("smtp", Boolean.TRUE);
            } else {
                mv.addObject("smtp", Boolean.FALSE);
            }
        } catch (Exception err) {
            LOGGER.error("Status", err);
            mv.addObject("smtp", Boolean.FALSE);
        }

        return mv;
    }
}
