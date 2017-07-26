package org.iclub.controller;

import java.util.Optional;
import javax.validation.Valid;

import org.iclub.model.CurrentUser;
import org.iclub.model.UpdateUserForm;
import org.iclub.model.User;
import org.iclub.service.UserService;
import org.iclub.validator.UserUpdateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class UpdateUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateUserController.class);

    private final UserService userService;
    private final UserUpdateValidator userUpdateFormValidator;

    @Autowired
    public UpdateUserController(UserService userService, UserUpdateValidator userUpdateFormValidator) {
        this.userService = userService;
        this.userUpdateFormValidator = userUpdateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userUpdateFormValidator);
    }

    @RequestMapping(value = "/update_user", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final Optional<User> option = userService.getUserByEmail( ((CurrentUser)auth.getPrincipal()).getUsername() );
        UpdateUserForm form = null;

        if (option.isPresent()) {
            form = new UpdateUserForm(option.get());
        } else {
            LOGGER.warn(auth.getPrincipal().toString() + " not found");
        }

        return new ModelAndView("user_update", "form", form);
    }

    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UpdateUserForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_update";
        }

        try {
            final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            final Optional<User> option = userService.getUserByEmail( ((CurrentUser)auth.getPrincipal()).getUsername() );

            if (option.isPresent()) {
                userService.save(form, option.get().getId(), option.get().getRole());
            }
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "user_update";
        }

        return "redirect:/update_user";
    }
}
