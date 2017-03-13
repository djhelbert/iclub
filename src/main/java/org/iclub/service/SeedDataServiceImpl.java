package org.iclub.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.iclub.model.Role;
import org.iclub.model.Setting;
import org.iclub.model.User;
import org.iclub.model.UserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SeedDataServiceImpl implements SeedDataService {

	private final UserService userService;
	private final SettingService settingService;

	private static final Logger LOGGER = LoggerFactory.getLogger(SeedDataServiceImpl.class);

	@Autowired
	public SeedDataServiceImpl(UserService userService, SettingService settingService) {
		this.userService = userService;
		this.settingService = settingService;
	}

	@Override
	public void init() {
		final List<User> adminUsers = userService.findByRole(Role.ADMIN);

		if (adminUsers.isEmpty()) {
			final UserForm admin = new UserForm();
			admin.setEmail("admin");
			admin.setFirstName("admin");
			admin.setLastName("admin");
			admin.setRole(Role.ADMIN);

			userService.save(admin);
		}

		createSetting(SettingService.FACEBOOK, "facebook");
		createSetting(SettingService.TWITTER, "Twitter");
		createSetting(SettingService.TITLE, "Default");
		createSetting(SettingService.DESCRIPTION, "This is the default descrption of the club.");
		createSetting(SettingService.PINTEREST, "pinterest");
		createSetting(SettingService.YOUTUBE, "youtube");
	}

	private void createSetting(String name, String value) {
		final Optional<Setting> optional = settingService.findSettingByName(name);

		if (!optional.isPresent()) {
			LOGGER.debug(name + " set to " + value);

			final Setting setting = new Setting();
			setting.setName(name);
			setting.setValue(value);

			settingService.save(setting);
		}
	}
}
