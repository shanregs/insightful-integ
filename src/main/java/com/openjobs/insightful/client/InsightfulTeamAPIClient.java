package com.openjobs.insightful.client;


import com.openjobs.insightful.config.InsightfulFeignConfig;
import com.openjobs.insightful.dto.CreateTeamRequest;
import com.openjobs.insightful.dto.TeamResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    TeamResponse createTeams(@RequestBody CreateTeamRequest request);
}