package com.openjobs.insightful.service;

import com.openjobs.insightful.client.InsightfulEmployeeAPIClient;

import com.openjobs.insightful.dto.*;
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
public class EmployeeService {

    private final InsightfulEmployeeAPIClient client;


    private static final String CB = "insightfulEmployee";
/*
    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetAll")
    public List<EmployeeResponse> getAll() {

        return client.getEmployees();
    }

    public List<EmployeeResponse> fallbackGetAll(Throwable ex) {
        log.error("Insightful API FAILED in getAll → using fallback: {}", ex.getMessage());
        return Collections.emptyList();
    }*/

/*    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetOne")
    public EmployeeResponse getById(String id) {
        return client.getEmployeeById(id);
    }

    public EmployeeResponse fallbackGetOne(String id, Throwable ex) {
        log.error("Insightful Employee API FAILED in getById({}) → using fallback", id);
        return null; // or a default object
    }*/

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackInvite")
    public EmployeeResponse invite(InviteEmployeeRequest request) {
        return client.inviteEmployee(request);
    }

    public EmployeeResponse fallbackInvite(SettingsRequest request, Throwable ex) {
        log.error("Insightful Employee API FAILED in create → fallback", ex);
        return null;
    }
}

