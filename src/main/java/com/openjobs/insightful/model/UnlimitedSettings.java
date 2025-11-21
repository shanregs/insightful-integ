package com.openjobs.insightful.model;

import com.openjobs.insightful.dto.Privileges;
import com.openjobs.insightful.dto.WeekDays;
import com.openjobs.insightful.model.enums.TrackingType;
import lombok.*;

@Data
@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@EqualsAndHashCode(callSuper = true)
public class UnlimitedSettings extends BaseSettings {

//    @Builder
    public UnlimitedSettings(Integer idle, Integer breaks, Integer screenshots,
                             WeekDays days, Boolean icon, Boolean timer,
                             Boolean clocker, Privileges privileges) {
        super(TrackingType.UNLIMITED, idle, breaks, screenshots, days, icon, timer, clocker, privileges);
    }
}
