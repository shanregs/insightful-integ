package com.jmi.jobseekerapi.feign.client;

import com.jmi.jobseekerapi.config.InsightfulFeignConfig;
import com.jmi.jobseekerapi.dto.request.SharedSettingsRequest;
import com.jmi.jobseekerapi.dto.response.SharedSettingsResponse;
import com.jmi.jobseekerapi.dto.request.UpdateSharedSettingsRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "insightfulSharedSettingsClient",
        url = "${insightful.api.base-url}/shared-settings",
        configuration = InsightfulFeignConfig.class
)
public interface InsightfulSharedSettingsAPIClient {
    @PostMapping
    SharedSettingsResponse createSharedSettings(@RequestBody SharedSettingsRequest request);

    @GetMapping
    List<SharedSettingsResponse> getSharedSettings();

    @GetMapping("/{id}")
    SharedSettingsResponse getSharedSettingById(@PathVariable("id") String id);

    @PutMapping("/{id}")
    SharedSettingsResponse updateSharedSetting(@PathVariable("id") String id,
                                               @RequestBody UpdateSharedSettingsRequest request);

    @DeleteMapping("/{id}")
    SharedSettingsResponse deleteSharedSetting(@PathVariable("id") String id);
}