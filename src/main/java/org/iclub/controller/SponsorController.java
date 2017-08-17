package org.iclub.controller;

import java.io.IOException;

import org.iclub.model.BinaryFile;
import org.iclub.model.Sponsor;
import org.iclub.service.SponsorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@ConditionalOnWebApplication
public class SponsorController {

    private final SponsorService sponsorService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SponsorController.class);

    @Autowired
    public SponsorController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    @RequestMapping(value = "/admin/sponsors", method = RequestMethod.POST)
    public String handleSponsorCreateForm(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("url") String url, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            final BinaryFile binaryFile = new BinaryFile();
            binaryFile.setName(file.getOriginalFilename());
            binaryFile.setMimetype(file.getContentType());

            try {
                binaryFile.setData(file.getBytes());

                final Sponsor sponsor = new Sponsor();
                sponsor.setName(name);
                sponsor.setDescription(description);
                sponsor.setUrl(url);
                sponsor.setBinaryFile(binaryFile);

                sponsorService.save(sponsor);
            } catch (IOException e) {
                LOGGER.error("Error setting binary file data.", e);
            }
        } catch (Exception e) {
            LOGGER.error("Save Sponsor Error", e);
            redirectAttributes.addFlashAttribute("error", "Unable to save sponsor.");
        }

        return "redirect:/admin/sponsors";
    }

    @RequestMapping(value ="/admin/sponsors/delete", method = RequestMethod.GET)
    public ModelAndView deleteSponsor(@RequestParam("id") String id) {
        sponsorService.delete(new Long(id));
        return new ModelAndView("admin_sponsors", "sponsors", sponsorService.findAll());
    }

    @RequestMapping(value ="/admin/sponsors", method = RequestMethod.GET)
    public ModelAndView getAdminSponsorsPage() {
        return new ModelAndView("admin_sponsors", "sponsors", sponsorService.findAll());
    }

    @RequestMapping(value = "/sponsors", method = RequestMethod.GET)
    public ModelAndView getSponsorsPage() {
        return new ModelAndView("sponsors", "sponsors", sponsorService.findAll());
    }
}
