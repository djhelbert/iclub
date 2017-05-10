package org.iclub.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ConditionalOnWebApplication
public class EmailController {

    @RequestMapping(value = "/admin/email", method = RequestMethod.GET)
    public ModelAndView getGroupEmailPage() {
        return new ModelAndView("admin_email");
    }

}
