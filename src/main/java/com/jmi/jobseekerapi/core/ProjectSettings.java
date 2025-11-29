package com.jmi.jobseekerapi.core;

import com.jmi.jobseekerapi.core.enums.TrackingType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProjectSettings extends BaseSettings {

    public ProjectSettings(Integer idle, Integer screenshots,
                           WeekDays days, Privileges privileges) {
        super(TrackingType.PROJECT, idle, 0, screenshots, days, true, true, false, privileges);
    }
}
