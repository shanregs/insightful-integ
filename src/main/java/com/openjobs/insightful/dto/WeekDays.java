package com.openjobs.insightful.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeekDays {
    @NotNull
    private Boolean monday;
    @NotNull private Boolean tuesday;
    @NotNull private Boolean wednesday;
    @NotNull private Boolean thursday;
    @NotNull private Boolean friday;
    @NotNull private Boolean saturday;
    @NotNull private Boolean sunday;
}