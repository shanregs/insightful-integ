package com.openjobs.insightful.dto;

import lombok.Data;

@Data
public class EmployeeSystemPermissionResponse {
    private String computerId;
    private String permissionType;
    private Long grantedAt;
}