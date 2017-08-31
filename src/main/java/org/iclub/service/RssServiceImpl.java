package org.iclub.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.iclub.model.Setting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Service
public class RssServiceImpl implements RssService, Runnable {

    private SettingService settingService;
    private volatile SyndFeed feed;
    private volatile List<SyndEntry> entries;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private static final Logger LOGGER = LoggerFactory.getLogger(SocialServiceImpl.class);

    @Autowired
    public RssServiceImpl(SettingService settingService) {
        this.settingService = settingService;

        scheduler.scheduleAtFixedRate(this, 1, 1, TimeUnit.HOURS);
    }

    @Override
    public void run() {
        LOGGER.debug("Clearing RSS");

        feed = null;
        entries = null;
    }

    @Override
    public SyndFeed getSyndFeed() throws Exception {
        if (feed != null) {
            return feed;
        }

        final Optional<Setting> setting = settingService.findSettingByName(SettingService.RSS);

        if (setting.isPresent()) {
            feed = getSyndFeed(setting.get().getValue());
            return feed;
        }

        return null;
    }

    public SyndFeed getSyndFeed(String feed) throws Exception {
        LOGGER.debug(feed);

        final URL feedUrl = new URL(feed);
        final SyndFeedInput input = new SyndFeedInput();
        final SyndFeed syndFeed = input.build(new XmlReader(feedUrl));

        return syndFeed;
    }

    @Override
    public List<SyndEntry> getSyndEntries() {
        if (entries != null) {
            return entries;
        }

        try {
            entries = getSyndFeed().getEntries();
            return entries;
        } catch (Exception err) {
            LOGGER.error("RssServiceImpl", err);
        }

        return new ArrayList<SyndEntry>();
    }
}
