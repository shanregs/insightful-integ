package com.jmi.jobseekerapi.controller;

import com.jmi.jobseekerapi.dto.request.SettingRequest;
import com.jmi.jobseekerapi.dto.response.SharedSettingsResponse;
import com.jmi.jobseekerapi.dto.request.UpdateSettingRequest;
import com.jmi.jobseekerapi.service.SharedSettingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/settings")
@RequiredArgsConstructor
@Slf4j
public class SettingsController {

    private final SharedSettingsService sharedSettingsService;

    @Operation(summary = "Create shared settings")
    @PostMapping
    public ResponseEntity<SharedSettingsResponse> createSetting(
            @Valid @RequestBody SettingRequest request   ) {
        SharedSettingsResponse sharedSettingsResponse = sharedSettingsService.createSetting(request);
        return ResponseEntity.ok(sharedSettingsResponse);
    }


    @Operation(summary = "Get all shared settings")
    @GetMapping
    public ResponseEntity<List<SharedSettingsResponse>> getAllSetting() {
        List<SharedSettingsResponse> all = sharedSettingsService.getAllSettings();
        return ResponseEntity.ok(all);
    }

    @Operation(summary = "Get one shared setting by ID")
    @GetMapping("/{id}")
    public ResponseEntity<SharedSettingsResponse> getSettingById(
            @Parameter(description = "Setting ID", required = true)
            @PathVariable(name = "id", required = true) String id
    ) {
        SharedSettingsResponse byId = sharedSettingsService.getSettingById(id);
        return ResponseEntity.ok(byId);
    }

    @Operation(summary = "Update an existing setting")
    @PutMapping("/{id}")
    public ResponseEntity<SharedSettingsResponse> updateSetting(
            @Parameter(description = "Setting ID", required = true)
            @PathVariable("id") String id,

            @Parameter(description = "Update Setting Request", required = true)
            @RequestBody UpdateSettingRequest request
    ) {
        SharedSettingsResponse updated = sharedSettingsService.updateSetting(id, request);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete an existing setting")
    @DeleteMapping("/{id}")
    public ResponseEntity<SharedSettingsResponse> deleteSetting(
            @Parameter(description = "Setting ID", required = true)
            @PathVariable("id") String id) {
        SharedSettingsResponse deactivated = sharedSettingsService.deleteSetting(id);
        return ResponseEntity.ok(deactivated);
    }
}
