package com.openjobs.insightful.controller;

import com.openjobs.insightful.dto.EmployeeResponse;
import com.openjobs.insightful.dto.InviteEmployeeRequest;
import com.openjobs.insightful.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "Invite an employee")
    @PostMapping()
    public ResponseEntity<EmployeeResponse> invite(

           @Valid @RequestBody InviteEmployeeRequest request
    ) {
        EmployeeResponse employeeResponse = employeeService.invite(request);
        return ResponseEntity.ok(employeeResponse);
    }


/*    @Operation(summary = "Get all employees")
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAll() {
        List<EmployeeResponse> all = employeeService.getAll();
        return ResponseEntity.ok(all);
    }*/

/*
    @Operation(summary = "Get one Employee by ID")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getById(
            @Parameter(description = "Employee ID", required = true)
            @PathVariable(name = "id", required = true) String id
    ) {
        EmployeeResponse byId = employeeService.getById(id);
        return ResponseEntity.ok(byId);
    }
*/


}
