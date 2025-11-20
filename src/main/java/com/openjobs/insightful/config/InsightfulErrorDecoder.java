package com.openjobs.insightful.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openjobs.insightful.exception.*;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class InsightfulErrorDecoder implements ErrorDecoder {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {

        String body = extractBody(response);

        log.error("Feign Error → method={} status={} body={}",
                methodKey, response.status(), body);

        String message = extractMessage(body);

        return switch (response.status()) {
            case 400 -> new InsightfulApiException("Bad Request: " + message, 400);
            case 401 -> new InsightfulUnauthorizedException("Unauthorized: Invalid / expired API key");
            case 403 -> new InsightfulApiException("Forbidden: " + message, 403);
            case 404 -> new InsightfulNotFoundException("Resource not found: " + message);
            case 429 -> new InsightfulApiException("Rate limit exceeded: Try again later", 429);
            case 500, 502, 503, 504 -> new InsightfulServerException(
                    "Insightful server error: " + message, response.status());
            default -> new InsightfulApiException("Unexpected error: " + message, response.status());
        };
    }

    private String extractBody(Response response) {
        try {
            if (response.body() == null) return "";
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "<no-body>";
        }
    }

    private String extractMessage(String body) {
        if (body == null || body.isBlank()) return "";
        try {
            JsonNode json = mapper.readTree(body);
            if (json.has("message")) return json.get("message").asText();
            if (json.has("error")) return json.get("error").asText();
            return body;
        } catch (IOException ignored) {
            return body;
        }
    }
}
