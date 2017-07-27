package org.iclub.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ConditionalOnWebApplication
public class IndexController {

    @RequestMapping("/")
    String index() {
        return "index";
    }
}