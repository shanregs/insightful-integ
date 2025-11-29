package com.jmi.jobseekerapi.service;

import com.jmi.jobseekerapi.dto.request.CreateProjectRequest;
import com.jmi.jobseekerapi.feign.client.InsightfulProjectAPIClient;
import com.jmi.jobseekerapi.core.Project;
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
public class ProjectService {

    private final InsightfulProjectAPIClient client;

    private static final String CB = "insightfulProject";

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetAll")
    public List<Project> getAllProjects() {

        return client.getProjects();
    }

    public List<Project> fallbackGetAll(Throwable ex) {
        log.error("Insightful API FAILED in getAll → using fallback: {}", ex.getMessage());
        return Collections.emptyList();
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetOne")
    public Project getProjectById(String id) {
        return client.getProjectById(id);
    }

    public Project fallbackGetOne(String id, Throwable ex) {
        log.error("Insightful Project API FAILED in getById({}) → using fallback", id);
        return null;
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackCreate")
    public Project createProject(CreateProjectRequest request) {
        return client.createProject(request);
    }

    public Project fallbackCreate(CreateProjectRequest request, Throwable ex) {
        log.error("Insightful Project API FAILED in create → fallback", ex);
        return null;
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackUpdate")
    public Project updateProject(String id, CreateProjectRequest request) {
        return client.updateProject(id, request);
    }

    public Project fallbackUpdate(String id, CreateProjectRequest request, Throwable ex) {
        log.error("Insightful Project API FAILED in update(id={}) → fallback: {}", id, ex.getMessage());
        return null;
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackDelete")
    public Project deleteProject(String id) {
        return client.deleteProject(id);
    }

    public Project fallbackDelete(String id, Throwable ex) {
        log.error("Insightful Project API FAILED in delete(id={}) → fallback: {}", id, ex.getMessage());
        return null;
    }
}

