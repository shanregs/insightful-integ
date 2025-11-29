package com.jmi.jobseekerapi.controller;

import com.jmi.jobseekerapi.dto.request.EmployeeOnboardRequest;
import com.jmi.jobseekerapi.dto.response.EmployeeResponse;
import com.jmi.jobseekerapi.service.EmployeeOnboardingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/onboard_employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeOnboardingController {

    private final EmployeeOnboardingService onboardingService;

    @PostMapping()
    public ResponseEntity<EmployeeResponse> inviteEmployee(

            @Valid @RequestBody EmployeeOnboardRequest request
    ) {
        EmployeeResponse employeeResponse = onboardingService.onboardEmployee(request);
        return ResponseEntity.ok(employeeResponse);
    }
}
