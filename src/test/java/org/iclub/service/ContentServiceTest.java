package org.iclub.service;

import java.util.Optional;

import org.iclub.model.Content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContentServiceTest {

    @Autowired
    private ContentService contentService;

    @Test
    public void testService() {
        contentService.save(getContent());
        final Optional<Content> optional = contentService.getContentByName(ContentService.ABOUT);
        assert optional.isPresent();
    }

    private Content getContent() {
        final Content content = new Content();
        content.setName(ContentService.ABOUT);
        content.setContentText("Text.....");
        return content;
    }
}
