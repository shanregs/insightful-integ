package com.openjobs.insightful.feign.client;


import com.openjobs.insightful.config.InsightfulFeignConfig;
import com.openjobs.insightful.dto.EmployeeResponse;
import com.openjobs.insightful.dto.InviteEmployeeRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "insightfulEmployeeClient",
        url = "${insightful.api.base-url}/Employee",
        configuration = InsightfulFeignConfig.class
)
public interface InsightfulEmployeeAPIClient {

    @GetMapping
    List<EmployeeResponse> getEmployees();

    @GetMapping("/{id}")
    EmployeeResponse getEmployeeById(@PathVariable("id") String id);

    @PostMapping
    EmployeeResponse inviteEmployee(@RequestBody InviteEmployeeRequest request);
}