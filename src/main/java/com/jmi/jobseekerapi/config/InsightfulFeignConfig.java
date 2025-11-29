package com.jmi.jobseekerapi.config;

import com.jmi.jobseekerapi.feign.InsightfulErrorDecoder;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsightfulFeignConfig {

    @Bean
    public RequestInterceptor insightfulAuthInterceptor(InsightfulApiProperties props) {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer " + props.getKey());
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");
        };
    }


    @Bean
    public ErrorDecoder insightfulErrorDecoder() {
        return new InsightfulErrorDecoder();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

