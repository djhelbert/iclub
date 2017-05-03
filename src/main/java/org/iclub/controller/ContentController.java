package org.iclub.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.iclub.model.Content;
import org.iclub.model.ContentForm;
import org.iclub.service.ContentService;
import org.iclub.validator.ContentValidator;
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
public class ContentController {

	private ContentService contentService;
	private ContentValidator contentValidator;

	private static final String CONTENT = "CONTENT";
	
    @Autowired
    public ContentController(ContentService contentService, ContentValidator contentValidator) {
        this.contentService = contentService;
        this.contentValidator = contentValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(contentValidator);
    }

    @RequestMapping(value = "/admin/privacy", method = RequestMethod.POST)
    public String handlePrivacyForm(@Valid @ModelAttribute("form") ContentForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin_privacy";
        }

        Optional<Content> content = contentService.getContentByName(ContentService.PRIVACY);

        if (content.isPresent()) {
        	Content aboutContent = content.get();
        	aboutContent.setContentText(form.getContent());
        	contentService.save(aboutContent);
        } else {
        	Content aboutContent = new Content();
        	aboutContent.setName(ContentService.PRIVACY);
        	aboutContent.setContentText(form.getContent());
        	contentService.save(aboutContent);
        }

        return "redirect:/content?name=PRIVACY";
    }

    @RequestMapping(value = "/admin/terms", method = RequestMethod.POST)
    public String handleTermsForm(@Valid @ModelAttribute("form") ContentForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin_terms";
        }

        Optional<Content> content = contentService.getContentByName(ContentService.TERMS);

        if (content.isPresent()) {
        	Content aboutContent = content.get();
        	aboutContent.setContentText(form.getContent());
        	contentService.save(aboutContent);
        } else {
        	Content aboutContent = new Content();
        	aboutContent.setName(ContentService.TERMS);
        	aboutContent.setContentText(form.getContent());
        	contentService.save(aboutContent);
        }

        return "redirect:/content?name=TERMS";
    }

    @RequestMapping(value = "/admin/about", method = RequestMethod.POST)
    public String handleAboutForm(@Valid @ModelAttribute("form") ContentForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin_about";
        }

        Optional<Content> content = contentService.getContentByName(ContentService.ABOUT);

        if (content.isPresent()) {
        	Content aboutContent = content.get();
        	aboutContent.setContentText(form.getContent());
        	contentService.save(aboutContent);
        } else {
        	Content aboutContent = new Content();
        	aboutContent.setName(ContentService.ABOUT);
        	aboutContent.setContentText(form.getContent());
        	contentService.save(aboutContent);
        }

        return "redirect:/content?name=ABOUT";
    }

    @RequestMapping(value = "/admin/privacy", method = RequestMethod.GET)
    public ModelAndView getPrivacyContent() {
    	final Optional<Content> optional = contentService.getContentByName(ContentService.PRIVACY);
        return new ModelAndView("admin_privacy", CONTENT, optional.isPresent() ? optional.get().getContentText() : "");
    }

    @RequestMapping(value = "/admin/terms", method = RequestMethod.GET)
    public ModelAndView getTermsContent() {
    	final Optional<Content> optional = contentService.getContentByName(ContentService.TERMS);
        return new ModelAndView("admin_terms", CONTENT, optional.isPresent() ? optional.get().getContentText() : "");
    }

    @RequestMapping(value = "/admin/about", method = RequestMethod.GET)
    public ModelAndView getAboutContent() {
    	final Optional<Content> optional = contentService.getContentByName(ContentService.ABOUT);
        return new ModelAndView("admin_about", CONTENT, optional.isPresent() ? optional.get().getContentText() : "");
    }

    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public ModelAndView getContent(@RequestParam("name") String name) {
    	final Optional<Content> optional = contentService.getContentByName(name);
        return new ModelAndView("content", CONTENT, optional.isPresent() ? optional.get().getContentText() : "");
    }
}
