package com.stavaray.challenge_tenpo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cache")
@Data
public class CacheProperties {
    private int ttl;
    private long maxSize;
}
