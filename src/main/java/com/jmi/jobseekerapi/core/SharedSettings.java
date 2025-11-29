package com.jmi.jobseekerapi.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SharedSettings {
    private String type;
    private Integer idle;
    private Integer breaks;
    private Integer screenshots;
    private Boolean idleScreenshots;
    private Boolean trackOutsideScheduledShift;

    private Integer start;


    private BreakTime breakTime;
    private WeekDays days;

    private Boolean icon;
    private Boolean timer;
    private Boolean clocker;

    private Privileges privileges;

    private Security security;
    private ScreenRecording screenRecording;

}
