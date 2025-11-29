package com.jmi.jobseekerapi.service;

import com.jmi.jobseekerapi.dto.response.EmployeeResponse;
import com.jmi.jobseekerapi.dto.request.InviteEmployeeRequest;
import com.jmi.jobseekerapi.dto.request.UpdateEmployeeRequest;
import com.jmi.jobseekerapi.feign.client.InsightfulEmployeeAPIClient;
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
public class EmployeeOnboardingService {

    private final InsightfulEmployeeAPIClient client;
    private static final String CB = "insightfulEmployee";

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetAll")
    public List<EmployeeResponse> getAllEmployees() {

        return client.getEmployees();
    }

    public List<EmployeeResponse> fallbackGetAll(Throwable ex) {
        log.error("Insightful API FAILED in getAll → using fallback: {}", ex.getMessage());
        return Collections.emptyList();
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetOne")
    public EmployeeResponse getEmployeeById(String id) {
        return client.getEmployeeById(id);
    }

    public EmployeeResponse fallbackGetOne(String id, Throwable ex) {
        log.error("Insightful Employee API FAILED in getById({}) → using fallback", id);
        return null; // or a default object
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackInvite")
    public EmployeeResponse inviteEmployee(InviteEmployeeRequest request) {
        return client.inviteEmployee(request);
    }

    public EmployeeResponse fallbackInvite(InviteEmployeeRequest request, Throwable ex) {
        log.error("Insightful Employee API FAILED in invite → fallback", ex);
        return null;
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackUpdate")
    public EmployeeResponse updateEmployee(String id, UpdateEmployeeRequest request) {
        return client.updateEmployee(id, request);
    }

    public EmployeeResponse fallbackUpdate(String id, UpdateEmployeeRequest request, Throwable ex) {
        log.error("Insightful Employee API FAILED in update(id={}) → fallback: {}", id, ex.getMessage());
        return null;
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackDeactivate")
    public EmployeeResponse deactivateEmployee(String id) {
        return client.deactivateEmployee(id);
    }

    public EmployeeResponse fallbackDeactivate(String id, Throwable ex) {
        log.error("Insightful Employee API FAILED in deactivate(id={}) → fallback: {}", id, ex.getMessage());
        return null;
    }
}

