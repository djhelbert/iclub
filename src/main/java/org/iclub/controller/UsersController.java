package org.iclub.controller;

import org.iclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ConditionalOnWebApplication
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/admin/users")
    public ModelAndView getUsersPage() {
        return new ModelAndView("admin_users", "users", userService.getAllUsers());
    }

    @RequestMapping(value ="/admin/users/delete", method = RequestMethod.GET)
    public ModelAndView deleteSponsor(@RequestParam("id") String id) {
        userService.delete(new Long(id));
        return new ModelAndView("admin_users", "users", userService.getAllUsers());
    }
}
