package org.iclub.service;

import org.iclub.repository.AbstractRepositoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RssServiceTest extends AbstractRepositoryTest {

    @Autowired
    RssService rssService;

    @Autowired
    SettingService settingService;

    @Test
    public void testRssService() {
        settingService.save(getSetting(SettingService.RSS, "http://rss.cnn.com/rss/cnn_topstories.rss"));

        try {
            assert rssService.getSyndFeed() != null ;
            assert rssService.getSyndEntries().size() > 0;
        } catch (Exception e) {
            assert false;
        }
    }
}
