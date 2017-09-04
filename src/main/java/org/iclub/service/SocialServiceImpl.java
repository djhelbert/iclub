package org.iclub.service;

import java.util.Optional;

import org.iclub.model.Setting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;
import facebook4j.auth.OAuthAuthorization;
import facebook4j.auth.OAuthSupport;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;

@Service
public class SocialServiceImpl implements SocialService {

    private SettingService settingService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SocialServiceImpl.class);

    @Autowired
    public SocialServiceImpl(SettingService settingService) {
        this.settingService = settingService;
    }

    private Configuration createConfiguration() throws FacebookException {
        final String appId = settingService.getFacebookAppId();
        final String secret = settingService.getFacebookAppSecret();

        if (appId != null  && secret != null) {
            ConfigurationBuilder confBuilder = new ConfigurationBuilder();
            confBuilder.setDebugEnabled(true);
            confBuilder.setOAuthAppId(appId);
            confBuilder.setOAuthAppSecret(secret);
            confBuilder.setUseSSL(true);
            confBuilder.setJSONStoreEnabled(true);

            Configuration configuration = confBuilder.build();
            return configuration;
        } else {
            throw new FacebookException("No configuration found");
        }
    }

    public Facebook getFacebook() throws FacebookException {
        final Configuration config = createConfiguration();

        FacebookFactory facebookFactory = new FacebookFactory(config);
        Facebook facebook = facebookFactory.getInstance();
        AccessToken accessToken = null;
        OAuthSupport oAuthSupport = new OAuthAuthorization(config);
        accessToken = oAuthSupport.getOAuthAppAccessToken();
        facebook.setOAuthAccessToken(accessToken);
        return facebook;
    }

    public User getUser(Facebook facebook) throws FacebookException {
        LOGGER.debug("Getting User");

        final Optional<Setting> setting = settingService.findSettingByName(SettingService.FACEBOOK);

        if (setting.isPresent() ) {
            return facebook.getUser(setting.get().getValue(), new Reading().fields("cover", "hometown", "link", "location", "picture"));
        } else {
            return null;
        }
    }

    public ResponseList<Post> getFeed(Facebook facebook, int size) throws FacebookException {
        LOGGER.debug("Getting Feed");

        final Optional<Setting> setting = settingService.findSettingByName(SettingService.FACEBOOK);

        if (setting.isPresent() ) {
            return facebook.getFeed(setting.get().getValue(), new Reading().limit(size).fields("icon", "description", "from", "permalink_url", "caption", "created_time", "full_picture", "place", "story", "updated_time", "name", "message", "link", "type"));
        } else {
            return null;
        }
    }
}
