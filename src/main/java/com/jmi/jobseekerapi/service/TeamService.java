package com.jmi.jobseekerapi.service;

import com.jmi.jobseekerapi.dto.request.CreateTeamRequest;
import com.jmi.jobseekerapi.dto.request.SharedSettingsRequest;
import com.jmi.jobseekerapi.dto.response.TeamResponse;
import com.jmi.jobseekerapi.dto.request.UpdateTeamRequest;
import com.jmi.jobseekerapi.feign.client.InsightfulTeamAPIClient;
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
public class TeamService {

    private final InsightfulTeamAPIClient client;
    private static final String CB = "insightfulTeam";

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackCreate")
    public TeamResponse createTeam(CreateTeamRequest request) {
        return client.createTeam(request);
    }

    public TeamResponse fallbackCreate(SharedSettingsRequest request, Throwable ex) {
        log.error("Insightful Team API FAILED in create → fallback", ex);
        return null;
    }


    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetOne")
    public TeamResponse getTeamById(String id) {
        return client.getTeamById(id);
    }

    public TeamResponse fallbackGetOne(String id, Throwable ex) {
        log.error("Insightful Team API FAILED in getById({}) → using fallback", id);
        return null; // or a default object
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetAll")
    public List<TeamResponse> getAllTeams() {

        return client.getTeams();
    }

    public List<TeamResponse> fallbackGetAll(Throwable ex) {
        log.error("Insightful API FAILED in getAll → using fallback: {}", ex.getMessage());
        return Collections.emptyList();
    }


    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackUpdate")
    public TeamResponse updateTeam(String id, UpdateTeamRequest request) {
        return client.updateTeam(id, request);
    }

    public TeamResponse fallbackUpdate(String id, UpdateTeamRequest request, Throwable ex) {
        log.error("Insightful Team API FAILED in update(id={}) → fallback: {}", id, ex.getMessage());
        return null;
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackDelete")
    public TeamResponse deletePTeam(String id) {
        return client.deleteTeam(id);
    }

    public TeamResponse fallbackDelete(String id, Throwable ex) {
        log.error("Insightful Team API FAILED in delete(id={}) → fallback: {}", id, ex.getMessage());
        return null;
    }
}

