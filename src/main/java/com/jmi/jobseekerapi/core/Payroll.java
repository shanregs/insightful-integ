package com.jmi.jobseekerapi.core;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Payroll {
    @NotNull
    private Double billRate;          // required
    private Double overtimeBillRate;  // optional
}
