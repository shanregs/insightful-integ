package com.jmi.jobseekerapi.controller;

import com.jmi.jobseekerapi.dto.response.EmployeeResponse;
import com.jmi.jobseekerapi.dto.request.InviteEmployeeRequest;
import com.jmi.jobseekerapi.dto.request.UpdateEmployeeRequest;
import com.jmi.jobseekerapi.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "Invite an employee")
    @PostMapping()
    public ResponseEntity<EmployeeResponse> inviteEmployee(

           @Valid @RequestBody InviteEmployeeRequest request
    ) {
        EmployeeResponse employeeResponse = employeeService.inviteEmployee(request);
        return ResponseEntity.ok(employeeResponse);
    }

    @Operation(summary = "Get one Employee by ID")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(
            @Parameter(description = "Employee ID", required = true)
            @PathVariable(name = "id", required = true) String id
    ) {
        EmployeeResponse byId = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(byId);
    }

    @Operation(summary = "Get all employees")
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        List<EmployeeResponse> all = employeeService.getAllEmployees();
        return ResponseEntity.ok(all);
    }


    @Operation(summary = "Update an existing Employee")
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(
            @Parameter(description = "Employee ID", required = true)
            @PathVariable("id") String id,

            @Parameter(description = "Update Employee Request", required = true)
            @RequestBody UpdateEmployeeRequest request
    ) {
        EmployeeResponse updated = employeeService.updateEmployee(id, request);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Deactivate an existing Employee")
    @GetMapping("/deactivate/{id}")
    public ResponseEntity<EmployeeResponse> deactivateEmployee(
            @Parameter(description = "Employee ID", required = true)
            @PathVariable("id") String id) {
        EmployeeResponse deactivated = employeeService.deactivateEmployee(id);
        return ResponseEntity.ok(deactivated);
    }
}
