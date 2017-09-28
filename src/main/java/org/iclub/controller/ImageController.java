package org.iclub.controller;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.iclub.model.BinaryFile;
import org.iclub.service.BinaryFileService;
import org.iclub.service.FreemarkerConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ImageController {

    private BinaryFileService binaryFileService;
    private FreemarkerConfigService freemarkerConfigService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);

    public ImageController(FreemarkerConfigService freemarkerConfigService, BinaryFileService binaryFileService) {
        this.binaryFileService = binaryFileService;
        this.freemarkerConfigService = freemarkerConfigService;
    }

    @RequestMapping(value = "/admin/images", method = RequestMethod.GET)
    public ModelAndView getAdminImagesPage(HttpServletRequest request) {
        final ModelAndView mv = new ModelAndView("admin_images");
        final Optional<BinaryFile> logoOption = binaryFileService.findBinaryFileByLogo(Boolean.TRUE);

        if (logoOption.isPresent()) {
            mv.addObject("logo", binaryFileService.findBinaryFileByLogo(Boolean.TRUE).get());
        }

        mv.addObject("scrollers", binaryFileService.findByScroller(Boolean.TRUE));

        if("true".equals(request.getParameter("added"))) {
            mv.addObject("message", "Image Added");
        }
        if("true".equals(request.getParameter("deleted"))) {
            mv.addObject("message", "Image Deleted");
        }
        if("true".equals(request.getParameter("updated"))) {
            mv.addObject("message", "Image Updated");
        }

        return mv;
    }

    @RequestMapping(value = "/admin/images/delete", method = RequestMethod.GET)
    public String deleteImage(@RequestParam("id") String id) {
        binaryFileService.delete(new Long(id));

        freemarkerConfigService.refresh();

        return "redirect:/admin/images?deleted=true";
    }

    @RequestMapping(value = "/admin/images/logo", method = RequestMethod.POST)
    public String handleLogoImageCreateForm(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            Optional<BinaryFile> optional = binaryFileService.findBinaryFileByLogo(Boolean.TRUE);

            if ( optional.isPresent() ) {
                final BinaryFile binaryFile = optional.get();
                binaryFile.setName(file.getOriginalFilename());
                binaryFile.setMimetype(file.getContentType());
                binaryFile.setData(file.getBytes());
                binaryFile.setLogo(Boolean.TRUE);
                binaryFile.setScroller(Boolean.FALSE);
                binaryFile.setResource(Boolean.FALSE);

                binaryFileService.save(binaryFile);
                freemarkerConfigService.refresh();
            } else {
                final BinaryFile binaryFile = new BinaryFile();
                binaryFile.setName(file.getOriginalFilename());
                binaryFile.setMimetype(file.getContentType());
                binaryFile.setData(file.getBytes());
                binaryFile.setLogo(Boolean.TRUE);
                binaryFile.setScroller(Boolean.FALSE);
                binaryFile.setResource(Boolean.FALSE);

                binaryFileService.save(binaryFile);
                freemarkerConfigService.refresh();
            }
        } catch (Exception e) {
            LOGGER.error("Save Logo Image Error", e);
            redirectAttributes.addFlashAttribute("error", "Unable to save logo image.");
        }

        return "redirect:/admin/images?updated=true";
    }

    @RequestMapping(value = "/admin/images/scroller", method = RequestMethod.POST)
    public String handleScrollerImageCreateForm(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            final BinaryFile binaryFile = new BinaryFile();
            binaryFile.setName(file.getOriginalFilename());
            binaryFile.setMimetype(file.getContentType());
            binaryFile.setData(file.getBytes());
            binaryFile.setLogo(Boolean.FALSE);
            binaryFile.setScroller(Boolean.TRUE);
            binaryFile.setResource(Boolean.FALSE);

            binaryFileService.save(binaryFile);
            freemarkerConfigService.refresh();
        } catch (Exception e) {
            LOGGER.error("Save Image Error", e);
            redirectAttributes.addFlashAttribute("error", "Unable to save image.");
        }

        return "redirect:/admin/images?added=true";
    }
}
