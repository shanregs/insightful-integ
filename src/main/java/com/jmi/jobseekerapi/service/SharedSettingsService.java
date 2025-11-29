package com.jmi.jobseekerapi.service;

import com.jmi.jobseekerapi.core.SharedSettings;
import com.jmi.jobseekerapi.dto.request.SharedSettingsRequest;
import com.jmi.jobseekerapi.dto.request.UpdateSharedSettingsRequest;
import com.jmi.jobseekerapi.dto.response.SharedSettingsResponse;
import com.jmi.jobseekerapi.feign.client.InsightfulSharedSettingsAPIClient;
import com.jmi.jobseekerapi.mapper.SettingsMapper;
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
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackCreate")
    public SharedSettingsResponse createSetting(SharedSettingsRequest request) {
        return client.createSharedSettings(request);
    }

    public SharedSettings fallbackCreate(SharedSettingsRequest request, Throwable ex) {
        log.error("Insightful API FAILED in create → fallback", ex);
        return null;
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetAll")
    public List<SharedSettingsResponse> getAllSettings() {
        return client.getSharedSettings();
    }

    public List<SharedSettingsResponse> fallbackGetAll(Throwable ex) {
        log.error("Insightful API FAILED in getAll → using fallback: {}", ex.getMessage());
        return Collections.emptyList();
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetOne")
    public SharedSettingsResponse getSettingById(String id) {
        return client.getSharedSettingById(id);
    }

    public SharedSettingsResponse fallbackGetOne(String id, Throwable ex) {
        log.error("Insightful API FAILED in getById({}) → using fallback", id);
        return null;
    }


    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackUpdate")
    public SharedSettingsResponse updateSetting(String id, UpdateSharedSettingsRequest request) {
        return client.updateSharedSetting(id, request);
    }

    public SharedSettingsResponse fallbackUpdate(String id, UpdateSharedSettingsRequest request, Throwable ex) {
        log.error("Insightful Setting API FAILED in update(id={}) → fallback: {}", id, ex.getMessage());
        return null;
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackDelete")
    public SharedSettingsResponse deleteSetting(String id) {
        return client.deleteSharedSetting(id);
    }

    public SharedSettingsResponse fallbackDelete(String id, Throwable ex) {
        log.error("Insightful Setting API FAILED in delete(id={}) → fallback: {}", id, ex.getMessage());
        return null;
    }


}

