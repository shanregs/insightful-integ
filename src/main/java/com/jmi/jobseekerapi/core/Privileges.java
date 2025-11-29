package com.jmi.jobseekerapi.core;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Privileges {
    private Boolean apps;
    private Boolean productivity;
    private Boolean screenshots;
    private Boolean pm;
    private Boolean offline;
    private Boolean manualTime;
    private Boolean manualTimeCreate;
    private Boolean shiftScheduling;
}