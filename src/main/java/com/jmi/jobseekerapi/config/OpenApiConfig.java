package com.jmi.jobseekerapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI configuration WITHOUT a global x-api-key security scheme
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI insightfulOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Insightful Integration API")
                        .description("Spring Boot service integrating with Insightful Shared Settings API")
                        .version("1.0.0"));
    }
}
