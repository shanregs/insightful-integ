package com.openjobs.insightful.model;

import lombok.Data;

@Data
public class EmployeeSystemPermission {
    private String computerId;
    private String permissionType;
    private Long grantedAt;
}