package com.tuling.service.impl;

import com.tuling.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * redis操作实现类
 */
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemlate<String, Object> redisTemlate;

    @Override
    public void set(String key, Object value, Long time) {
        redisTemlate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }
}
