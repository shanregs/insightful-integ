package com.jmi.jobseekerapi.core;

import lombok.Data;
import java.util.List;

@Data
public class Employee {

    private String id;
    private String name;
    private String teamId;
    private String sharedSettingsId;
    private String accountId;
    private String identifier;
    private String type;              // personal | office
    private String organizationId;
    private List<String> projects;
    private Long deactivated;
    private Long invited;
    private Long createdAt;
    private List<EmployeeSystemPermission> systemPermissions;
}
