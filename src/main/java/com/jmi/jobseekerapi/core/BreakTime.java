package com.jmi.jobseekerapi.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmi.jobseekerapi.core.enums.BreakTimeType;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BreakTime {
    @JsonProperty("type")
    private BreakTimeType type;
    private Integer allowance;
    private Boolean overage;
    private Boolean multipleOverage;
}