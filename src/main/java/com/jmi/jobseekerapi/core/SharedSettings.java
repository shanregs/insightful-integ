package com.jmi.jobseekerapi.core;

import com.jmi.jobseekerapi.core.enums.SettingsMode;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SharedSettings {
    private SettingsMode type;
    private Integer idle;
    private Integer breaks;
    private Integer screenshots;
    private Boolean idleScreenshots;
    private Boolean trackOutsideScheduledShift;
    private BreakTime breakTime;
    private WeekDays days;
    private Privileges privileges;
    private Security security;
    private ScreenRecording screenRecording;
    private Boolean icon;
    private Boolean timer;
    private Boolean clocker;
}
