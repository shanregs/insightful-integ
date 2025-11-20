package com.openjobs.insightful.controller;

import com.openjobs.insightful.dto.SettingsRequest;
import com.openjobs.insightful.dto.SharedSettingsResponse;
import com.openjobs.insightful.service.SharedSettingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/settings")
@RequiredArgsConstructor
@Slf4j
public class SettingsController {

    private final SharedSettingsService sharedSettingsService;

    @Operation(summary = "Get all shared settings")
    @GetMapping
    public ResponseEntity<List<SharedSettingsResponse>> getAll(    ) {
        List<SharedSettingsResponse> all = sharedSettingsService.getAll();
        return ResponseEntity.ok(all);
    }

    @Operation(summary = "Get one shared setting by ID")
    @GetMapping("/{id}")
    public ResponseEntity<SharedSettingsResponse> getById(
            @Parameter(description = "Setting ID", required = true)
            @PathVariable(name = "id", required = true) String id
    ) {
        SharedSettingsResponse byId = sharedSettingsService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @Operation(summary = "Create shared settings")
    @PostMapping
    public ResponseEntity<SharedSettingsResponse> create(

            @Valid @RequestBody SettingsRequest request
    ) {
        SharedSettingsResponse sharedSettingsResponse = sharedSettingsService.create(request);
        return ResponseEntity.ok(sharedSettingsResponse);
    }

    private String extractToken(String bearerHeader) {
        return bearerHeader.replace("Bearer ", "").trim();
    }
}
