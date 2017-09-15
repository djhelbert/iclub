package org.iclub.controller;

import javax.servlet.http.HttpServletRequest;

import org.iclub.model.BinaryFile;
import org.iclub.service.BinaryFileService;
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
public class ResourceController {
    private BinaryFileService binaryFileService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceController.class);

    public ResourceController(BinaryFileService binaryFileService) {
        this.binaryFileService = binaryFileService;
    }

    @RequestMapping(value = "/admin/resources", method = RequestMethod.GET)
    public ModelAndView getAdminResourcePage(HttpServletRequest request) {
        final ModelAndView mv = new ModelAndView("admin_resources");

        String requestUrl = request.getRequestURL().toString().replace("/admin/resources", "");

        mv.addObject("requestUrl", requestUrl);
        mv.addObject("resources", binaryFileService.findByResource(Boolean.TRUE));

        if("true".equals(request.getParameter("added"))) {
            mv.addObject("message", "Resource Added");
        }

        if("true".equals(request.getParameter("deleted"))) {
            mv.addObject("message", "Resource Deleted");
        }

        if("true".equals(request.getParameter("updated"))) {
            mv.addObject("message", "Resource Updated");
        }

        return mv;
    }

    @RequestMapping(value = "/admin/resources/delete", method = RequestMethod.GET)
    public String deleteImage(@RequestParam("id") String id) {
        binaryFileService.delete(new Long(id));

        return "redirect:/admin/resources?deleted=true";
    }

    @RequestMapping(value = "/admin/resources", method = RequestMethod.POST)
    public String handleScrollerImageCreateForm(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            final BinaryFile binaryFile = new BinaryFile();
            binaryFile.setName(file.getOriginalFilename());
            binaryFile.setMimetype(file.getContentType());
            binaryFile.setData(file.getBytes());
            binaryFile.setLogo(Boolean.FALSE);
            binaryFile.setScroller(Boolean.FALSE);
            binaryFile.setResource(Boolean.TRUE);

            binaryFileService.save(binaryFile);
        } catch (Exception e) {
            LOGGER.error("Save Resource Error", e);
            redirectAttributes.addFlashAttribute("error", "Unable to save resource.");
        }

        return "redirect:/admin/resources?added=true";
    }
}
