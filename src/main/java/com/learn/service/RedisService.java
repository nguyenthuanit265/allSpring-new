package com.learn.service;

public interface RedisService {
    boolean isRedisServerUp();

    void setValue(String key, String value);

    Object getValue(String key);
}
