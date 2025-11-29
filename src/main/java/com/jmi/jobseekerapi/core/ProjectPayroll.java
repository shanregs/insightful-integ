package com.jmi.jobseekerapi.core;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectPayroll {
    private String employeeId;

    @NotNull
    private Payroll payroll;  // required
}
