package org.iclub.service;

import java.util.Optional;
import javax.transaction.Transactional;

import org.iclub.model.Setting;
import org.iclub.repository.SettingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SettingServiceImpl implements SettingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SettingServiceImpl.class);
	private final SettingRepository settingRepository;
	
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
	public Setting create(Setting setting) {
		LOGGER.debug("Saving:" + setting.toString());
		return settingRepository.save(setting);
	}

}
