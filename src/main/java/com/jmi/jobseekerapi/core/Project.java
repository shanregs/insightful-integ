package com.jmi.jobseekerapi.core;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    private String id;
    private boolean archived;
    private List<String> statuses;
    private List<String> priorities;
    private boolean billable;
    private ProjectPayroll payroll;
    private String name;
    private String description;
    private List<String> employees;
    private String creatorId;
    private String organizationId;
    private List<String> teams;
    private Long createdAt;
    private ScreenshotSettings screenshotSettings;
}
