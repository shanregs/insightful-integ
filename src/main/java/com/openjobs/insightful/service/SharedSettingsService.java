package com.openjobs.insightful.service;

import com.openjobs.insightful.feign.client.InsightfulSharedSettingsAPIClient;
import com.openjobs.insightful.dto.SettingsRequest;
import com.openjobs.insightful.dto.SharedSettings;
import com.openjobs.insightful.dto.SharedSettingsResponse;
import com.openjobs.insightful.mapper.SettingsMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SharedSettingsService {

    private final InsightfulSharedSettingsAPIClient client;
    private final SettingsMapper mapper;

    private static final String CB = "insightfulSharedSettings";

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetAll")
    public List<SharedSettingsResponse> getAll() {
//        return client.getSharedSettings().stream().map(mapper::toEntity).toList();
        return client.getSharedSettings();
    }

    public List<SharedSettingsResponse> fallbackGetAll(Throwable ex) {
        log.error("Insightful API FAILED in getAll → using fallback: {}", ex.getMessage());
        return Collections.emptyList();
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetOne")
    public SharedSettingsResponse getById(String id) {
        return client.getSharedSettingById(id);
    }

    public SharedSettingsResponse fallbackGetOne(String id, Throwable ex) {
        log.error("Insightful API FAILED in getById({}) → using fallback", id);
        return null; // or a default object
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackCreate")
    public SharedSettingsResponse create(SettingsRequest request) {
        return client.createSharedSettings(request);
    }

    public SharedSettings fallbackCreate(SettingsRequest request, Throwable ex) {
        log.error("Insightful API FAILED in create → fallback", ex);
        return null;
    }
}

