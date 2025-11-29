package com.jmi.jobseekerapi.dto.response;

import lombok.Data;

@Data
public class EmployeeSystemPermissionResponse {
    private String computerId;
    private String permissionType;
    private Long grantedAt;
}