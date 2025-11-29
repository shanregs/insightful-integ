package com.jmi.jobseekerapi.dto.response;

import com.jmi.jobseekerapi.core.SharedSettings;
import com.jmi.jobseekerapi.core.enums.SharedSettingsType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SharedSettingsResponse {
    private String id;
    private String name;
    private String organizationId;
    private SharedSettingsType type;
    private SharedSettings settings;
    private Boolean isDefault;
    private String description;
    private Long createdAt;
    private Long updatedAt;
//    private String modelName;
}