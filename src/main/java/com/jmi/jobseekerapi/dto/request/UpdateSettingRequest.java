package com.jmi.jobseekerapi.dto.request;

import com.jmi.jobseekerapi.core.Settings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSettingRequest {

    private String name;

    private String type;

    private Settings settings;

    private String description;
}