package org.iclub.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.iclub.model.BinaryFile;
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
	private final BinaryFileService binaryFileService;

	private static final Logger LOGGER = LoggerFactory.getLogger(SeedDataServiceImpl.class);

	@Autowired
	public SeedDataServiceImpl(UserService userService, SettingService settingService, BinaryFileService binaryFileService) {
		this.userService = userService;
		this.settingService = settingService;
		this.binaryFileService = binaryFileService;
	}

	@Override
	public void init() {
		final List<User> adminUsers = userService.findByRole(Role.ADMIN);

		if (adminUsers.isEmpty()) {
			final UserForm admin = new UserForm();
			admin.setEmail("admin");
			admin.setFirstName("iClub");
			admin.setLastName("Administrator");
			admin.setRole(Role.ADMIN);

			userService.save(admin);
		}

		createSetting(SettingService.FACEBOOK, "facebook");
		createSetting(SettingService.TWITTER, "Twitter");
		createSetting(SettingService.TITLE, "Default");
		createSetting(SettingService.DESCRIPTION, "This is the default descrption of the club.");
		createSetting(SettingService.PINTEREST, "pinterest");
		createSetting(SettingService.YOUTUBE, "youtube");

		Optional<BinaryFile> optional = binaryFileService.findBinaryFileByLogo(Boolean.TRUE);

		if (!optional.isPresent()) {
			try {
				binaryFileService.save(BinaryFile.getBinaryFile("/images/logo_default.png", "image/png", true, false, false));
			} catch (IOException | URISyntaxException e) {
				LOGGER.error("Seeding Logo Image", e);
			}
		}

		final List<BinaryFile> scrollers = binaryFileService.findByScroller(Boolean.TRUE);

		if (scrollers == null || scrollers.size() == 0) {
			try {
				binaryFileService.save(BinaryFile.getBinaryFile("/images/cycling.jpg", "image/png", false, true, false));
				binaryFileService.save(BinaryFile.getBinaryFile("/images/forest-runner.jpg", "image/jpeg", false, true, false));
				binaryFileService.save(BinaryFile.getBinaryFile("/images/mountain-bikers.jpg", "image/jpeg", false, true, false));
				binaryFileService.save(BinaryFile.getBinaryFile("/images/open_water.jpg", "image/jpeg", false, true, false));
				binaryFileService.save(BinaryFile.getBinaryFile("/images/trail-runners.jpg", "image/jpeg", false, true, false));
			} catch (IOException | URISyntaxException e) {
				LOGGER.error("Saving Default Scrollers", e);
			}
		}
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
