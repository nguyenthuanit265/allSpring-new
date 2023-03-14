package com.learn.service.impl;

import com.learn.service.RedisService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Objects;

@Service
public class RedisServiceImpl implements RedisService {
    private final Logger LOGGER = LoggerFactory.getLogger(RedisServiceImpl.class);
    private final RedisConnectionFactory redisConnectionFactory;
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisServiceImpl(RedisConnectionFactory redisConnectionFactory,
                            RedisTemplate<String, Object> redisTemplate) {
        this.redisConnectionFactory = redisConnectionFactory;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean isRedisServerUp() {
        boolean isUp = false;
        RedisConnection redisConnection = null;
        LOGGER.info("Check connect redis server");
        try {
            redisConnection = redisConnectionFactory.getConnection();
            isUp = Objects.equals(redisConnection.ping(), "PONG");
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            ex.printStackTrace();
        } finally {
            if (redisConnection != null) {
                redisConnection.close();
            }
        }
        LOGGER.info(isUp ? "Connected" : "Connect failed");
        return isUp;
    }

    @PostConstruct
    private void initRedisData() {
        String key = "allSpring2";
        if (ObjectUtils.isEmpty(getValue(key))) {
            setValue("allSpring2", "2");
        }
    }

    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteAllKeys() {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.serverCommands().flushDb();
            return null;
        });
    }

    @PostConstruct
    public void checkRedisServerUp() {
        isRedisServerUp();
    }
}
