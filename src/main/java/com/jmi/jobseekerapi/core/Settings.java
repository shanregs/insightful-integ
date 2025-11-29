package com.jmi.jobseekerapi.core;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Settings {
    private String type;
    private Boolean icon;
    private Boolean timer;
    private Boolean clocker;
    private Integer start;
    private Integer idle;
    private Integer breaks;
    private Integer screenshots;
    private BreakTime breakTime;
    private WeekDays days;
    private Privileges privileges;
}