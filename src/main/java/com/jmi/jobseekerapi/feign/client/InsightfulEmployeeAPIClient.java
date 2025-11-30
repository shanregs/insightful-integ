package com.jmi.jobseekerapi.feign.client;


import com.jmi.jobseekerapi.config.InsightfulFeignConfig;
import com.jmi.jobseekerapi.dto.response.EmployeeResponse;
import com.jmi.jobseekerapi.dto.request.InviteEmployeeRequest;
import com.jmi.jobseekerapi.dto.request.UpdateEmployeeRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "insightfulEmployeeClient",
        url = "${insightful.api.base-url}/employee",
        configuration = InsightfulFeignConfig.class
)
public interface InsightfulEmployeeAPIClient {
    @PostMapping
    EmployeeResponse inviteEmployee(@RequestBody InviteEmployeeRequest request);

    @GetMapping("/{id}")
    EmployeeResponse getEmployeeById(@PathVariable("id") String id);

    @GetMapping
    List<EmployeeResponse> getEmployees();

    @GetMapping(params = "status=pending")
    List<EmployeeResponse> getPendingEmployees();

    @GetMapping(params = "status=deactivated")
    List<EmployeeResponse> getDeactivatedEmployees();

    @PutMapping("/{id}")
    EmployeeResponse updateEmployee(@PathVariable("id") String id, @RequestBody UpdateEmployeeRequest request);

    @GetMapping("/deactivate/{id}")
    EmployeeResponse deactivateEmployee(@PathVariable("id") String id);
}