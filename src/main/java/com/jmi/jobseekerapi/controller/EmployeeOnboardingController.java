package com.jmi.jobseekerapi.controller;

import com.jmi.jobseekerapi.dto.request.CreateTeamRequest;
import com.jmi.jobseekerapi.dto.response.TeamResponse;
import com.jmi.jobseekerapi.dto.request.UpdateTeamRequest;
import com.jmi.jobseekerapi.service.EmployeeOnboardingService;
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
public class EmployeeOnboardingController {

    private final EmployeeOnboardingService onboardingService;


}
