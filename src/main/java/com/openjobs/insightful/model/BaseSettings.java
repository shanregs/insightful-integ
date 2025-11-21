package com.openjobs.insightful.model;

import com.openjobs.insightful.dto.Privileges;
import com.openjobs.insightful.dto.WeekDays;
import com.openjobs.insightful.model.enums.PrivilegeLevel;
import com.openjobs.insightful.model.enums.TrackingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseSettings {

    @NotNull
    private TrackingType type;          // Type of tracking

    @NotNull
    private Integer idle;               // Idle time

    @NotNull
    private Integer breaks;             // Breaks

    @NotNull
    private Integer screenshots;        // Screenshots

    @NotNull
    private WeekDays days;              // Days of the week (enum)

    @NotNull
    private Boolean icon;               // Show icon in taskbar

    @NotNull
    private Boolean timer;              // Show Projects & Tasks

    @NotNull
    private Boolean clocker;            // Show timer

    @NotNull
    private Privileges privileges;  // Employee privileges
}
