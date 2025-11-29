package com.jmi.jobseekerapi.core;

import com.jmi.jobseekerapi.core.enums.TrackingType;
import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ManualSettings extends BaseSettings {

    public ManualSettings(Integer idle, Integer breaks, Integer screenshots,
                          WeekDays days, Boolean timer, Privileges privileges) {
        super(TrackingType.MANUAL, idle, breaks, screenshots, days, true, timer, true, privileges);
    }
}
