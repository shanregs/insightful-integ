package com.openjobs.insightful.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectPayroll {
    private String employeeId;

    @NotNull
    private Payroll payroll;  // required
}
