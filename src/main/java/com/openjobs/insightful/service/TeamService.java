package com.openjobs.insightful.service;

import com.openjobs.insightful.feign.client.InsightfulTeamAPIClient;
import com.openjobs.insightful.dto.CreateTeamRequest;
import com.openjobs.insightful.dto.SettingsRequest;
import com.openjobs.insightful.dto.TeamResponse;
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
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetAll")
    public List<TeamResponse> getAll() {

        return client.getTeams();
    }

    public List<TeamResponse> fallbackGetAll(Throwable ex) {
        log.error("Insightful API FAILED in getAll → using fallback: {}", ex.getMessage());
        return Collections.emptyList();
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackGetOne")
    public TeamResponse getById(String id) {
        return client.getTeamById(id);
    }

    public TeamResponse fallbackGetOne(String id, Throwable ex) {
        log.error("Insightful Team API FAILED in getById({}) → using fallback", id);
        return null; // or a default object
    }

    @Retry(name = CB)
    @CircuitBreaker(name = CB, fallbackMethod = "fallbackCreate")
    public TeamResponse create(CreateTeamRequest request) {
        return client.createTeams(request);
    }

    public TeamResponse fallbackCreate(SettingsRequest request, Throwable ex) {
        log.error("Insightful Team API FAILED in create → fallback", ex);
        return null;
    }
}

