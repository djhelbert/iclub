package org.iclub.service;

import java.util.Optional;

import org.iclub.model.Setting;
import org.iclub.model.SettingForm;

public interface SettingService {

    String CONTACT_ADDRESS_LINE1 = "CONTACT_ADDRESS_LINE1";
    String CONTACT_ADDRESS_LINE2 = "CONTACT_ADDRESS_LINE2";
    String CONTACT_CITY = "CONTACT_CITY";
    String CONTACT_STATE = "CONTACT_STATE";
    String CONTACT_ZIP_CODE = "CONTACT_ZIP_CODE";
    String CONTACT_PHONE = "CONTACT_PHONE";
    String DESCRIPTION = "DESCRIPTION";
    String FACEBOOK = "FACEBOOK";
    String FACEBOOK_APP_ID = "FACEBOOK_APP_ID";
    String FACEBOOK_APP_SECRET = "FACEBOOK_APP_SECRET";
    String PINTEREST = "PINTEREST";
    String YOUTUBE = "YOUTUBE";
    String CONTACT_EMAIL = "CONTACT_EMAIL";
    String LOGO = "LOGO";
    String SCROLLERS = "SCROLLERS";
    String SMTP_EMAIL = "SMTP_EMAIL";
    String SMTP_PASSWORD = "SMTP_PASSWORD";
    String STRAVA = "STRAVA";
    String TITLE = "TITLE";
    String TWITTER = "TWITTER";

    Optional<Setting> findSettingByName(String name);

    Setting save(Setting setting);

    SettingForm getSettingForm();
}
