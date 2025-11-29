package com.jmi.jobseekerapi.core;

import com.jmi.jobseekerapi.core.enums.BreakTimeType;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BreakTime {
    private BreakTimeType type;
    private Integer allowance;
    private Boolean overage;
    private Boolean multipleOverage;
}