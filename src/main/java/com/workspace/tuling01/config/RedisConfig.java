package com.workspace.tuling01.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {
}
