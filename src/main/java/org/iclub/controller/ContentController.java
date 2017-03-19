package org.iclub.controller;

import java.util.Optional;

import org.iclub.model.Content;
import org.iclub.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ConditionalOnWebApplication
public class ContentController {

	private ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public ModelAndView getContent(@RequestParam("name") String name) {
    	final Optional<Content> optional = contentService.getContentByName(name);

        return new ModelAndView("content", "CONTENT", optional.isPresent() ? optional.get().getContentText() : "");
    }
}
