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
	public boolean init() {
		boolean updated = false;

		final List<User> adminUsers = userService.findByRole(Role.ADMIN);

		if (adminUsers.isEmpty()) {
			final UserForm adminForm = new UserForm();
			adminForm.setEmail("admin");
			adminForm.setFirstName("iClub");
			adminForm.setLastName("Administrator");
			adminForm.setRole(Role.ADMIN);
			adminForm.setPassword("admin");
			adminForm.setPasswordConfirm("admin");
			adminForm.setAgree(true);
			userService.save(adminForm);

			LOGGER.info("Seeding admin user...");

			updated = true;
		}

		if ( createSetting(SettingService.FACEBOOK, "facebook") ) {updated = true;}
		if ( createSetting(SettingService.TWITTER, "Twitter") ) {updated = true;}
		if ( createSetting(SettingService.TITLE, "Default") ) {updated = true;}
		if ( createSetting(SettingService.DESCRIPTION, "This is the default descrption of the club.") ) {updated = true;}
		if ( createSetting(SettingService.PINTEREST, "pinterest") ) {updated = true;}
		if ( createSetting(SettingService.YOUTUBE, "youtube") ) {updated = true;}

		Optional<BinaryFile> optional = binaryFileService.findBinaryFileByLogo(Boolean.TRUE);

		if (!optional.isPresent()) {
			try {
				binaryFileService.save(BinaryFile.getBinaryFile("/images/logo_default.png", "image/png", true, false, false));
				LOGGER.info("Seeding default logo...");
				updated = true;
			} catch (IOException | URISyntaxException e) {
				LOGGER.error("Error Seeding Logo Image", e);
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

				updated = true;
			} catch (IOException | URISyntaxException e) {
				LOGGER.error("Error Saving Default Scrollers", e);
			}
		}

		return updated;
	}

	private boolean createSetting(String name, String value) {
		final Optional<Setting> optional = settingService.findSettingByName(name);

		if (!optional.isPresent()) {
			LOGGER.debug(name + " set to " + value);

			final Setting setting = new Setting();
			setting.setName(name);
			setting.setValue(value);

			settingService.save(setting);
			return true;
		}

		return false;
	}
}
