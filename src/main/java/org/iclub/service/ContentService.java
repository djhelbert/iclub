package org.iclub.service;

import java.util.Optional;

import org.iclub.model.Content;

public interface ContentService {

	public String ABOUT = "ABOUT";
	public String TERMS = "TERMS";
	public String PRIVACY = "PRIVACY";

	Optional<Content> getContentByName(String name);
	Content save(Content content);
}
