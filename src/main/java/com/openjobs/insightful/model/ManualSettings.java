package com.openjobs.insightful.model;

import com.openjobs.insightful.dto.Privileges;
import com.openjobs.insightful.dto.WeekDays;
import com.openjobs.insightful.model.enums.PrivilegeLevel;
import com.openjobs.insightful.model.enums.TrackingType;
import lombok.*;

@Data
@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@EqualsAndHashCode(callSuper = true)
public class ManualSettings extends BaseSettings {

//    @Builder
    public ManualSettings(Integer idle, Integer breaks, Integer screenshots,
                          WeekDays days, Boolean timer, Privileges privileges) {
        super(TrackingType.MANUAL, idle, breaks, screenshots, days, true, timer, true, privileges);
    }
}
