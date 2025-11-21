package com.openjobs.insightful.feign.client;



import com.openjobs.insightful.config.InsightfulFeignConfig;
import com.openjobs.insightful.dto.SettingsRequest;
import com.openjobs.insightful.dto.SharedSettingsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "insightfulSharedSettingsClient",
        url = "${insightful.api.base-url}/shared-settings",
        configuration = InsightfulFeignConfig.class
)
public interface InsightfulSharedSettingsAPIClient {

    @GetMapping
    List<SharedSettingsResponse> getSharedSettings();

    @GetMapping("/{id}")
    SharedSettingsResponse getSharedSettingById(@PathVariable("id") String id);

    @PostMapping
    SharedSettingsResponse createSharedSettings(@RequestBody SettingsRequest request);
}