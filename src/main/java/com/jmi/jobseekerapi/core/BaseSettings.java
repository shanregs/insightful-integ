package com.jmi.jobseekerapi.core;

import com.jmi.jobseekerapi.core.enums.TrackingType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseSettings {

    @NotNull
    private TrackingType type;

    @NotNull
    private Integer idle;

    @NotNull
    private Integer breaks;

    @NotNull
    private Integer screenshots;

    @NotNull
    private WeekDays days;

    @NotNull
    private Boolean icon;

    @NotNull
    private Boolean timer;

    @NotNull
    private Boolean clocker;

    @NotNull
    private Privileges privileges;
}
