package com.stavaray.challenge_tenpo.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableConfigurationProperties(CacheProperties.class)
public class CacheConfig {

    @Bean
    public CacheManager cacheManager(CacheProperties props) {
        CaffeineCacheManager mgr = new CaffeineCacheManager("percentage");
        mgr.setCaffeine(
                Caffeine.newBuilder()
                        .expireAfterWrite(props.getTtl(), TimeUnit.MINUTES)
                        .maximumSize(props.getMaxSize())
        );
        return mgr;
    }
}
