package com.openjobs.insightful.dto;

import com.openjobs.insightful.model.enums.BreakTimeType;
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