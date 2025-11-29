package com.jmi.jobseekerapi.core;

import lombok.Data;

@Data
public class EmployeeSystemPermission {
    private String computerId;
    private String permissionType;
    private Long grantedAt;
}