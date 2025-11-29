package com.jmi.jobseekerapi.controller;

import com.jmi.jobseekerapi.dto.request.CreateTeamRequest;
import com.jmi.jobseekerapi.dto.response.TeamResponse;
import com.jmi.jobseekerapi.dto.request.UpdateTeamRequest;
import com.openjobs.insightful.dto.*;
import com.jmi.jobseekerapi.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
@Slf4j
public class TeamsController {

    private final TeamService teamsService;

    @Operation(summary = "Get all teams")
    @GetMapping
    public ResponseEntity<List<TeamResponse>> getAllTeams() {
        List<TeamResponse> all = teamsService.getAllTeams();
        return ResponseEntity.ok(all);
    }

    @Operation(summary = "Get one team by ID")
    @GetMapping("/{id}")
    public ResponseEntity<TeamResponse> getTeamById(
            @Parameter(description = "Team ID", required = true)
            @PathVariable(name = "id", required = true) String id
    ) {
        TeamResponse byId = teamsService.getTeamById(id);
        return ResponseEntity.ok(byId);
    }

    @Operation(summary = "Create teams")
    @PostMapping
    public ResponseEntity<TeamResponse> createTeam(

            @Valid @RequestBody CreateTeamRequest request
    ) {
        TeamResponse teamResponse = teamsService.createTeam(request);
        return ResponseEntity.ok(teamResponse);
    }

    @Operation(summary = "Update an existing Team")
    @PutMapping("/{id}")
    public ResponseEntity<TeamResponse> updateTeam(
            @Parameter(description = "Team ID", required = true)
            @PathVariable("id") String id,

            @Parameter(description = "Update Team Request", required = true)
            @RequestBody UpdateTeamRequest request
    ) {
        TeamResponse updated = teamsService.updateTeam(id, request);
        return ResponseEntity.ok(updated);
    }
}
