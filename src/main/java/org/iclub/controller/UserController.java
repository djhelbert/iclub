package org.iclub.controller;

import javax.validation.Valid;
import org.iclub.model.UserForm;
import org.iclub.service.UserService;
import org.iclub.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.dao.DataIntegrityViolationException;
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
public class UserController {

    private final UserService userService;
    private final UserValidator userCreateFormValidator;

    @Autowired
    public UserController(UserService userService, UserValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        return new ModelAndView("user_create", "form", new UserForm());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_create";
        }

        try {
            userService.save(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "user_create";
        }

        return "redirect:/login";
    }
}
