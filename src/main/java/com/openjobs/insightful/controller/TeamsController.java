package com.openjobs.insightful.controller;

import com.openjobs.insightful.dto.CreateTeamRequest;
import com.openjobs.insightful.dto.TeamResponse;
import com.openjobs.insightful.service.TeamService;
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
    public ResponseEntity<List<TeamResponse>> getAll() {
        List<TeamResponse> all = teamsService.getAll();
        return ResponseEntity.ok(all);
    }

    @Operation(summary = "Get one team by ID")
    @GetMapping("/{id}")
    public ResponseEntity<TeamResponse> getById(
            @Parameter(description = "Team ID", required = true)
            @PathVariable(name = "id", required = true) String id
    ) {
        TeamResponse byId = teamsService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @Operation(summary = "Create teams")
    @PostMapping
    public ResponseEntity<TeamResponse> create(

            @Valid @RequestBody CreateTeamRequest request
    ) {
        TeamResponse teamResponse = teamsService.create(request);
        return ResponseEntity.ok(teamResponse);
    }

}
