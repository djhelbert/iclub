package org.iclub.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.iclub.model.Setting;
import org.iclub.model.SettingForm;
import org.iclub.service.FreemarkerConfigService;
import org.iclub.service.SettingService;
import org.iclub.validator.SettingValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
	private final FreemarkerConfigService freemarkerConfigService;
	private final SettingService settingService;
	private final SettingValidator settingValidator;

	private static final Logger LOGGER = LoggerFactory.getLogger(SettingController.class);

	@Autowired
	public SettingController(FreemarkerConfigService freemarkerConfigService, SettingService settingService, SettingValidator settingValidator) {
		this.freemarkerConfigService = freemarkerConfigService;
		this.settingService = settingService;
		this.settingValidator = settingValidator;
	}

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(settingValidator);
    }

    @RequestMapping(value = "/admin/settings", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        return new ModelAndView("admin_settings", "form", settingService.getSettingForm());
    }

    @RequestMapping(value = "/admin/settings", method = RequestMethod.POST)
    public String handleUpdateSettingForm(@Valid @ModelAttribute("form") SettingForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin_settings";
        }

		createSetting(SettingService.FACEBOOK, form.getFacebook());
		createSetting(SettingService.TWITTER, form.getTwitter());
		createSetting(SettingService.TITLE, form.getTitle());
		createSetting(SettingService.PINTEREST, form.getPinterest());
		createSetting(SettingService.YOUTUBE, form.getYoutube());
		createSetting(SettingService.CONTACT_ADDRESS_LINE1, form.getContactAddressLine1());
		createSetting(SettingService.CONTACT_ADDRESS_LINE2, form.getContactAddressLine2());
		createSetting(SettingService.CONTACT_EMAIL, form.getContactEmail());
		createSetting(SettingService.CONTACT_CITY, form.getContactCity());
		createSetting(SettingService.CONTACT_STATE, form.getContactState());
		createSetting(SettingService.CONTACT_ZIP_CODE, form.getContactZipCode());
		createSetting(SettingService.CONTACT_PHONE, form.getContactPhone());
		createSetting(SettingService.STRAVA, form.getStrava());

        freemarkerConfigService.refresh();

        return "redirect:/";
    }

	private void createSetting(String name, String value) {
		final Optional<Setting> optional = settingService.findSettingByName(name);

		if (!optional.isPresent()) {
			LOGGER.debug(name + " set to " + value);

			final Setting setting = new Setting();
			setting.setName(name);
			setting.setValue(value == null ? "" : value);

			settingService.save(setting);
		} else {
			LOGGER.debug(name + " set to " + value);

			Setting setting = optional.get();
			setting.setValue(value);

			settingService.save(setting);
		}
	}
}
