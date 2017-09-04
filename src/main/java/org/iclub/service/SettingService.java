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
    String PINTEREST = "PINTEREST";
    String YOUTUBE = "YOUTUBE";
    String CONTACT_EMAIL = "CONTACT_EMAIL";
    String LOGO = "LOGO";
    String RSS = "RSS";
    String SCROLLERS = "SCROLLERS";
    String STRAVA = "STRAVA";
    String BANNER = "BANNER";
    String TITLE = "TITLE";
    String TWITTER = "TWITTER";


    Optional<Setting> findSettingByName(String name);
    Setting save(Setting setting);
    SettingForm getSettingForm();
    String getEncryptionKey();
    void setEncryptionKey(String encryptionKey);
    String getSmtpPassword();
    void setSmtpPassword(String smtpPassword);
    String getSmtpEmailAddress();
    void setSmtpEmailAddress(String smtpEmailAddress);
    String getFacebookAppId();
    void setFacebookAppId(String facebookAppId);
    String getFacebookAppSecret();
    void setFacebookAppSecret(String facebookAppSecret);
}
