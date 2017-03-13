package org.iclub.service;

import java.util.Optional;

import org.iclub.model.Setting;
import org.iclub.model.SettingForm;

public interface SettingService {

	String TITLE = "TITLE";
	String DESCRIPTION = "DESCRIPTION";
	String TWITTER = "TWITTER";
	String FACEBOOK = "FACEBOOK";
	String PINTEREST = "PINTEREST";
	String YOUTUBE = "YOUTUBE";
	String CONTACT_EMAIL = "CONTACT_EMAIL";
	String CONTACT_ADDRESS_LINE1 = "CONTACT_ADDRESS_LINE1";
	String CONTACT_ADDRESS_LINE2 = "CONTACT_ADDRESS_LINE2";
	String CONTACT_CITY = "CONTACT_CITY";
	String CONTACT_STATE = "CONTACT_STATE";
	String CONTACT_ZIP_CODE = "CONTACT_ZIP_CODE";
	String CONTACT_PHONE = "CONTACT_PHONE";
	String STRAVA = "STRAVA";

	Optional<Setting> findSettingByName(String name);

	Setting save(Setting setting);

	SettingForm getSettingForm();
}
