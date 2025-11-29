package com.jmi.jobseekerapi.feign.client;


import com.jmi.jobseekerapi.config.InsightfulFeignConfig;
import com.jmi.jobseekerapi.dto.request.CreateProjectRequest;
import com.jmi.jobseekerapi.core.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "insightfulProjectClient",
        url = "${insightful.api.base-url}/Project",
        configuration = InsightfulFeignConfig.class
)
public interface InsightfulProjectAPIClient {

    @GetMapping
    List<Project> getProjects();

    @GetMapping("/{id}")
    Project getProjectById(@PathVariable("id") String id);

    @PostMapping
    Project createProject(@RequestBody CreateProjectRequest request);

    @PutMapping("/{id}")
    Project updateProject(@PathVariable("id") String id, @RequestBody CreateProjectRequest request);

    @GetMapping("/delete/{id}")
    Project deleteProject(@PathVariable("id") String id);
}