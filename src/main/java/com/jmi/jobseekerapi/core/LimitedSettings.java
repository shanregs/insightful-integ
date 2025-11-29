package com.jmi.jobseekerapi.core;

import com.jmi.jobseekerapi.core.enums.TrackingType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LimitedSettings extends BaseSettings {

    @NotNull
    private Long start; // Shift start time (ms)

    @NotNull
    private Long end;   // Shift end time (ms)

    public LimitedSettings(Integer idle, Integer breaks, Integer screenshots,
                           WeekDays days, Boolean icon, Boolean timer, Boolean clocker,
                           Privileges privileges, Long start, Long end) {
        super(TrackingType.LIMITED, idle, breaks, screenshots, days, icon, timer, clocker, privileges);
        this.start = start;
        this.end = end;
    }
}
