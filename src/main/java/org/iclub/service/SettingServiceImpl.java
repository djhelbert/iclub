package org.iclub.service;

import java.util.Optional;
import javax.transaction.Transactional;

import org.iclub.model.Setting;
import org.iclub.model.SettingForm;
import org.iclub.repository.SettingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SettingServiceImpl implements SettingService {

	private final SettingRepository settingRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(SettingServiceImpl.class);

	@Autowired
	public SettingServiceImpl(SettingRepository settingRepository) {
		this.settingRepository = settingRepository;
	}

	@Override
	public Optional<Setting> findSettingByName(String name) {
		LOGGER.debug("Getting setting by name={}", name);

		return settingRepository.findSettingByName(name);
	}

	@Override
	public Setting save(Setting setting) {
		LOGGER.debug("Saving:" + setting.toString());

		return settingRepository.save(setting);
	}

	@Override
	public SettingForm getSettingForm() {
		SettingForm form = new SettingForm();

		form.setContactAddressLine1(getValue(settingRepository.findSettingByName(SettingService.CONTACT_ADDRESS_LINE1)));
		form.setContactAddressLine2(getValue(settingRepository.findSettingByName(SettingService.CONTACT_ADDRESS_LINE2)));
		form.setContactEmail(getValue(settingRepository.findSettingByName(SettingService.CONTACT_EMAIL)));
		form.setContactCity(getValue(settingRepository.findSettingByName(SettingService.CONTACT_CITY)));
		form.setContactState(getValue(settingRepository.findSettingByName(SettingService.CONTACT_STATE)));
		form.setContactZipCode(getValue(settingRepository.findSettingByName(SettingService.CONTACT_ZIP_CODE)));

		form.setTitle(getValue(settingRepository.findSettingByName(SettingService.TITLE)));
		form.setDescription(getValue(settingRepository.findSettingByName(SettingService.DESCRIPTION)));

		form.setStrava(getValue(settingRepository.findSettingByName(SettingService.STRAVA)));
		form.setFacebook(getValue(settingRepository.findSettingByName(SettingService.FACEBOOK)));
		form.setYoutube(getValue(settingRepository.findSettingByName(SettingService.YOUTUBE)));
		form.setPinterest(getValue(settingRepository.findSettingByName(SettingService.PINTEREST)));
		form.setTwitter(getValue(settingRepository.findSettingByName(SettingService.TWITTER)));

		return form;
	}

	private String getValue(Optional<Setting> optional) {
		if (optional != null && optional.isPresent()) {
			return optional.get().getValue();
		} else {
			return "";
		}
	}
}
