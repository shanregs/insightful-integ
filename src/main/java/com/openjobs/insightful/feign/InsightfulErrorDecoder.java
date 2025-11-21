package com.openjobs.insightful.feign;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openjobs.insightful.exception.*;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
public class InsightfulErrorDecoder implements ErrorDecoder {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {

        String body = extractBody(response);

        log.error("Feign Error → {} | Status={} | Body={}", methodKey, response.status(), body);

        JsonNode json = parseJson(body);
        String message = extractMessage(json, body);

        return switch (response.status()) {

            case 400 -> parseValidationError(json, message);

            case 401 -> new InsightfulUnauthorizedException("Unauthorized: Invalid or expired API key");

            case 403 -> new InsightfulApiException("Forbidden: " + message, 403);

            case 404 -> new InsightfulNotFoundException("Not found: " + message);

            case 409 -> new DuplicateTeamException("Duplicated team: " + message);

            case 429 -> new InsightfulApiException("Rate limit exceeded", 429);

            case 500, 502, 503, 504 ->
                    new InsightfulServerException("Insightful server error: " + message, response.status());

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

    private JsonNode parseJson(String body) {
        try {
            return mapper.readTree(body);
        } catch (Exception e) {
            return null;
        }
    }

    private String extractMessage(JsonNode json, String fallback) {
        if (json == null) return fallback;
        if (json.has("message")) return json.get("message").asText();
        if (json.has("error")) return json.get("error").asText();
        return fallback;
    }

    private Exception parseValidationError(JsonNode json, String message) {

        if (json == null || !json.has("details")) {
            return new InsightfulApiException("Bad Request: " + message, 400);
        }

        List<Map<String, Object>> details = new ArrayList<>();

        json.get("details").forEach(node -> {
            Map<String, Object> entry = new HashMap<>();
            node.fields().forEachRemaining(f -> entry.put(f.getKey(), f.getValue()));
            details.add(entry);
        });

        return new InsightfulValidationException(message, details);
    }
}
