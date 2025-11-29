package com.jmi.jobseekerapi.dto.request;


import com.jmi.jobseekerapi.core.Settings;
import lombok.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettingRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @Valid
    @NotNull
    private Settings settings;
}
