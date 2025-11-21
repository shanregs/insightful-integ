package com.openjobs.insightful.model;

import com.openjobs.insightful.dto.Privileges;
import com.openjobs.insightful.dto.WeekDays;
import com.openjobs.insightful.model.enums.PrivilegeLevel;
import com.openjobs.insightful.model.enums.TrackingType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@EqualsAndHashCode(callSuper = true)
public class LimitedSettings extends BaseSettings {

    @NotNull
    private Long start; // Shift start time (ms)

    @NotNull
    private Long end;   // Shift end time (ms)

//    @Builder
    public LimitedSettings(Integer idle, Integer breaks, Integer screenshots,
                           WeekDays days, Boolean icon, Boolean timer, Boolean clocker,
                           Privileges privileges, Long start, Long end) {
        super(TrackingType.LIMITED, idle, breaks, screenshots, days, icon, timer, clocker, privileges);
        this.start = start;
        this.end = end;
    }
}
