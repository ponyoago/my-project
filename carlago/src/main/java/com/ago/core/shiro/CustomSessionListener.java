package com.ago.core.shiro;


import com.ago.core.redis.RedisConfiguration;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;


@Configuration
public class CustomSessionListener implements SessionListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedisConfiguration redisConfiguration;

    /**
     * 一个回话的生命周期开始
     */
    @Override
    public void onStart(Session session) {
        logger.info("onStart:{}", session.getId());
    }
    /**
     * 一个回话的生命周期结束
     */
    @Override
    public void onStop(Session session) {
        logger.info("onStop:{}", session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        logger.info("onExpiration:{}", session.getId());
        redisTemplate.delete(redisConfiguration.getSessionPrefix() + session.getId().toString());
    }

}

