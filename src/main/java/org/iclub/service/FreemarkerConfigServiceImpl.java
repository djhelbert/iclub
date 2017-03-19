package org.iclub.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.iclub.model.BinaryFile;
import org.iclub.model.Setting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;

@Service
@ConditionalOnWebApplication
public class FreemarkerConfigServiceImpl implements FreemarkerConfigService {

	private final FreeMarkerConfigurer configurer;
	private final SettingService settingService;
	private final BinaryFileService binaryFileService;
	private static final Logger LOGGER = LoggerFactory.getLogger(FreemarkerConfigServiceImpl.class);

	@Autowired
	public FreemarkerConfigServiceImpl(FreeMarkerConfigurer configurer, SettingService settingService, BinaryFileService binaryFileService) {
		this.configurer = configurer;
		this.settingService = settingService;
		this.binaryFileService = binaryFileService;

		refresh();
	}

	@Override
	public void refresh() {
		Configuration configuration = configurer.getConfiguration();
		try {
			configuration.setSharedVariable(SettingService.TITLE, getValue(settingService.findSettingByName(SettingService.TITLE)));
			configuration.setSharedVariable(SettingService.DESCRIPTION, getValue(settingService.findSettingByName(SettingService.DESCRIPTION)));
			configuration.setSharedVariable(SettingService.TWITTER, getValue(settingService.findSettingByName(SettingService.TWITTER)));
			configuration.setSharedVariable(SettingService.FACEBOOK, getValue(settingService.findSettingByName(SettingService.FACEBOOK)));
			configuration.setSharedVariable(SettingService.PINTEREST, getValue(settingService.findSettingByName(SettingService.PINTEREST)));
			configuration.setSharedVariable(SettingService.YOUTUBE, getValue(settingService.findSettingByName(SettingService.YOUTUBE)));
			configuration.setSharedVariable(SettingService.STRAVA, getValue(settingService.findSettingByName(SettingService.STRAVA)));
			configuration.setSharedVariable(SettingService.CONTACT_EMAIL, getValue(settingService.findSettingByName(SettingService.CONTACT_EMAIL)));
			configuration.setSharedVariable(SettingService.CONTACT_ADDRESS_LINE1, getValue(settingService.findSettingByName(SettingService.CONTACT_ADDRESS_LINE1)));
			configuration.setSharedVariable(SettingService.CONTACT_ADDRESS_LINE2, getValue(settingService.findSettingByName(SettingService.CONTACT_ADDRESS_LINE2)));
			configuration.setSharedVariable(SettingService.CONTACT_CITY, getValue(settingService.findSettingByName(SettingService.CONTACT_CITY)));
			configuration.setSharedVariable(SettingService.CONTACT_STATE, getValue(settingService.findSettingByName(SettingService.CONTACT_STATE)));
			configuration.setSharedVariable(SettingService.CONTACT_ZIP_CODE, getValue(settingService.findSettingByName(SettingService.CONTACT_ZIP_CODE)));
			configuration.setSharedVariable(SettingService.CONTACT_PHONE, getValue(settingService.findSettingByName(SettingService.CONTACT_PHONE)));

			final Long logoId = getBinaryFileValue(binaryFileService.findBinaryFileByLogo(Boolean.TRUE));

			if (logoId != null) {
				configuration.setSharedVariable(SettingService.LOGO, logoId);
			}

			final List<BinaryFile> scrollers = binaryFileService.findByScroller(Boolean.TRUE);

			if (scrollers != null && scrollers.size() > 0) {
				List<Long> scrollerIds = scrollers.parallelStream().map(BinaryFile::getId).collect(Collectors.toList());
				configuration.setSharedVariable(SettingService.SCROLLERS, scrollerIds);
			}
		} catch (TemplateModelException e) {
			LOGGER.error("refresh", e);
		}
	}

	private Long getBinaryFileValue(Optional<BinaryFile> optional) {
		if (optional != null && optional.isPresent()) {
			return optional.get().getId();
		} else {
			return null;
		}
	}
	
	private String getValue(Optional<Setting> optional) {
		if (optional != null && optional.isPresent()) {
			return optional.get().getValue();
		} else {
			return "";
		}
	}
}
