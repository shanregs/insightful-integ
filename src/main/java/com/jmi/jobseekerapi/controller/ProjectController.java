package com.jmi.jobseekerapi.controller;

import com.jmi.jobseekerapi.dto.request.CreateProjectRequest;
import com.jmi.jobseekerapi.core.Project;
import com.jmi.jobseekerapi.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
@Slf4j
public class ProjectController {

    private final ProjectService projectService;

    @Operation(summary = "Create an project")
    @PostMapping()
    public ResponseEntity<Project> create(@Valid @RequestBody CreateProjectRequest request) {
        Project project = projectService.createProject(request);
        return ResponseEntity.ok(project);
    }

    @Operation(summary = "Get all Projects")
    @GetMapping
    public ResponseEntity<List<Project>> getAll() {
        List<Project> all = projectService.getAllProjects();
        return ResponseEntity.ok(all);
    }


    @Operation(summary = "Get one Project by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Project> getById(
            @Parameter(description = "Project ID", required = true)
            @PathVariable(name = "id", required = true) String id
    ) {
        Project byId = projectService.getProjectById(id);
        return ResponseEntity.ok(byId);
    }

    @Operation(summary = "Update an existing Project")
    @PutMapping("/{id}")
    public ResponseEntity<Project> update(
            @Parameter(description = "Project ID", required = true)
            @PathVariable("id") String id,

            @Parameter(description = "Update Project Request", required = true)
            @RequestBody CreateProjectRequest request
    ) {
        Project updated = projectService.updateProject(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Project> delete(
            @Parameter(description = "Project ID", required = true)
            @PathVariable("id") String id) {
        Project deactivated = projectService.deleteProject(id);
        return ResponseEntity.ok(deactivated);
    }
}
