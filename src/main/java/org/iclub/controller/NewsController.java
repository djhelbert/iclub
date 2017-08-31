package org.iclub.controller;

import java.util.concurrent.TimeUnit;

import org.iclub.service.SocialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import facebook4j.Facebook;
import facebook4j.FacebookException;

@Controller
@ConditionalOnWebApplication
public class NewsController {

    private SocialService socialService;
    private LoadingCache<String, Facebook> cache;

    private static final String KEY = "key";
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    public NewsController(SocialService socialService) {
        this.socialService = socialService;

        cache = CacheBuilder.newBuilder().expireAfterWrite(15, TimeUnit.MINUTES)
                .maximumSize(10)
                .build(new CacheLoader<String, Facebook>() {
                    @Override
                    public Facebook load(String key) throws Exception {
                        return socialService.getFacebook();
                    }
                });
    }

    @RequestMapping(value ="/news", method = RequestMethod.GET)
    public ModelAndView news() {
        ModelAndView mv = null;

        try {
            Facebook facebook = cache.getIfPresent(KEY);

            if (facebook == null) {
                LOGGER.debug("Creating New Facebook Instance");
                facebook = socialService.getFacebook();
                cache.put(KEY, facebook);
            }

            mv = new ModelAndView("news", "posts", socialService.getFeed(facebook, 20));
            mv.addObject("user", socialService.getUser(facebook));
        } catch (FacebookException e) {
            LOGGER.error("Get Faceook Feed", e);
        }

        return mv;
    }
}
