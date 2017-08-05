package org.iclub.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.iclub.model.Content;
import org.iclub.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContentServiceImpl implements ContentService {

    private ContentRepository contentRepository;

    @Autowired
    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public Optional<Content> getContentByName(String name) {
        return contentRepository.findContentByName(name);
    }

    @Override
    public Content save(Content content) {
        return contentRepository.save(content);
    }
}
