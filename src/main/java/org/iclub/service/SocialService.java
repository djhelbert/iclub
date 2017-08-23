package org.iclub.service;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.User;

public interface SocialService {

    public Facebook getFacebook() throws FacebookException;
    public ResponseList<Post> getFeed(Facebook facebook, int size) throws FacebookException;
    public User getUser(Facebook facebook) throws FacebookException;

}
