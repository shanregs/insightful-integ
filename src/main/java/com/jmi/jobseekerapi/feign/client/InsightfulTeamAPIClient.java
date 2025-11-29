package com.jmi.jobseekerapi.feign.client;


import com.jmi.jobseekerapi.config.InsightfulFeignConfig;
import com.jmi.jobseekerapi.dto.request.CreateTeamRequest;
import com.jmi.jobseekerapi.dto.response.TeamResponse;
import com.jmi.jobseekerapi.dto.request.UpdateTeamRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "insightfulTeamClient",
        url = "${insightful.api.base-url}/team",
        configuration = InsightfulFeignConfig.class
)
public interface InsightfulTeamAPIClient {

    @GetMapping
    List<TeamResponse> getTeams();

    @GetMapping("/{id}")
    TeamResponse getTeamById(@PathVariable("id") String id);

    @PostMapping
    TeamResponse createTeam(@RequestBody CreateTeamRequest request);

    @PutMapping("/{id}")
    TeamResponse updateTeam(@PathVariable("id") String id, @RequestBody UpdateTeamRequest request);

    @DeleteMapping ("/{id}")
    TeamResponse deleteTeam(@PathVariable("id") String id);

}