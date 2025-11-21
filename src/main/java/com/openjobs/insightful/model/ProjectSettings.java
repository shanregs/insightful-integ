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
public class ProjectSettings extends BaseSettings {

//    @Builder
    public ProjectSettings(Integer idle, Integer screenshots,
                           WeekDays days, Privileges privileges) {
        super(TrackingType.PROJECT, idle, 0, screenshots, days, true, true, false, privileges);
    }
}
