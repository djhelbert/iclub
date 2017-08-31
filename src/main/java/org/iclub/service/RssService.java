package org.iclub.service;

import java.util.List;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;

public interface RssService {

    public SyndFeed getSyndFeed() throws Exception;
    public List<SyndEntry> getSyndEntries();

}
