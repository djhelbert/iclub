package org.iclub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.iclub.email.EmailUtil;
import org.iclub.model.EmailForm;
import org.iclub.model.User;
import org.iclub.service.SettingService;
import org.iclub.service.UserService;
import org.iclub.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ConditionalOnWebApplication
public class EmailController {

    private final SettingService settingService;
    private final EmailValidator emailFormValidator;
    private final UserService userService;

    private final static String EMAIL_HEAD = "<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/></head>";

    @Autowired
    public EmailController(SettingService settingService, UserService userService, EmailValidator emailFormValidator) {
        this.settingService = settingService;
        this.emailFormValidator = emailFormValidator;
        this.userService = userService;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(emailFormValidator);
    }

    @RequestMapping(value = "/admin/email", method = RequestMethod.GET)
    public ModelAndView getGroupEmailPage(HttpServletRequest request) {
        final EmailForm form = new EmailForm();
        form.setFromEmail(settingService.findSettingByName(SettingService.CONTACT_EMAIL).get().getValue());

        final ModelAndView mv = new ModelAndView("admin_email", "form", form);

        if("true".equals(request.getParameter("sent"))) {
            mv.addObject("message", "Email Message Sent");
        }

        return mv;
    }

    @RequestMapping(value = "/admin/email", method = RequestMethod.POST)
    public String handleEmailForm(@Valid @ModelAttribute("form") EmailForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin_email";
        }

        final String name = settingService.findSettingByName(SettingService.TITLE).get().getValue();
        final String body = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\">" + EMAIL_HEAD + "<body style=\"width:100%; margin:0; padding:0;\">" + form.getBody() + "</body></html>";

        for (User user : userService.getAllUsers()) {
            if (!user.isAdmin()) {
                EmailUtil.sendEmail(form.getFromEmail(), form.getPassword(), name, user.getEmail(), form.getSubject(), body);
            }
        }

        return "redirect:/admin/email?sent=true";
    }
}
