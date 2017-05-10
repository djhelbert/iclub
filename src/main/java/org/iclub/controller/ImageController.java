package org.iclub.controller;

import org.iclub.service.BinaryFileService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ConditionalOnWebApplication
public class ImageController {

    private BinaryFileService binaryFileService;

    public ImageController(BinaryFileService binaryFileService) {
        this.binaryFileService = binaryFileService;
    }

    @RequestMapping(value = "/admin/images", method = RequestMethod.GET)
    public ModelAndView getAdminImagesPage() {
        final ModelAndView mv = new ModelAndView("admin_images");
        mv.addObject("logo", binaryFileService.findBinaryFileByLogo(Boolean.TRUE));
        mv.addObject("scrollers", binaryFileService.findByScroller(Boolean.TRUE));

        return mv;
    }

}
