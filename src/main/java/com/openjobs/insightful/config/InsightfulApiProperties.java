package com.openjobs.insightful.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "insightful.api")
@Data
public class InsightfulApiProperties {
    private String baseUrl;
    private String key;
}