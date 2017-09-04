package org.iclub.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.iclub.model.Setting;
import org.iclub.model.SettingForm;
import org.iclub.repository.SettingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@Transactional
@ConfigurationProperties("iclub")
public class SettingServiceImpl implements SettingService {

    private final SettingRepository settingRepository;

    private String smtpPassword;
    private String smtpEmailAddress;
    private String facebookAppId;
    private String facebookAppSecret;

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

    public String getSmtpPassword() {
        return smtpPassword;
    }

    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }

    public String getSmtpEmailAddress() {
        return smtpEmailAddress;
    }

    public void setSmtpEmailAddress(String smtpEmailAddress) {
        this.smtpEmailAddress = smtpEmailAddress;
    }

    public String getFacebookAppId() {
        return facebookAppId;
    }

    public void setFacebookAppId(String facebookAppId) {
        this.facebookAppId = facebookAppId;
    }

    public String getFacebookAppSecret() {
        return facebookAppSecret;
    }

    public void setFacebookAppSecret(String facebookAppSecret) {
        this.facebookAppSecret = facebookAppSecret;
    }

    @Override
    public SettingForm getSettingForm() {
        final SettingForm form = new SettingForm();

        form.setDescription(getValue(settingRepository.findSettingByName(SettingService.DESCRIPTION)));
        form.setContactAddressLine1(getValue(settingRepository.findSettingByName(SettingService.CONTACT_ADDRESS_LINE1)));
        form.setContactAddressLine2(getValue(settingRepository.findSettingByName(SettingService.CONTACT_ADDRESS_LINE2)));
        form.setContactEmail(getValue(settingRepository.findSettingByName(SettingService.CONTACT_EMAIL)));
        form.setContactCity(getValue(settingRepository.findSettingByName(SettingService.CONTACT_CITY)));
        form.setContactState(getValue(settingRepository.findSettingByName(SettingService.CONTACT_STATE)));
        form.setContactZipCode(getValue(settingRepository.findSettingByName(SettingService.CONTACT_ZIP_CODE)));
        form.setContactPhone(getValue(settingRepository.findSettingByName(SettingService.CONTACT_PHONE)));
        form.setPinterest(getValue(settingRepository.findSettingByName(SettingService.PINTEREST)));
        form.setRss(getValue(settingRepository.findSettingByName(SettingService.RSS)));
        form.setStrava(getValue(settingRepository.findSettingByName(SettingService.STRAVA)));
        form.setBanner(getValue(settingRepository.findSettingByName(SettingService.BANNER)));
        form.setTitle(getValue(settingRepository.findSettingByName(SettingService.TITLE)));
        form.setTwitter(getValue(settingRepository.findSettingByName(SettingService.TWITTER)));
        form.setYoutube(getValue(settingRepository.findSettingByName(SettingService.YOUTUBE)));
        form.setFacebook(getValue(settingRepository.findSettingByName(SettingService.FACEBOOK)));

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
