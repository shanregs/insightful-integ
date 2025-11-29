package com.jmi.jobseekerapi.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmi.jobseekerapi.core.Settings;
import com.jmi.jobseekerapi.core.SharedSettings;
import com.jmi.jobseekerapi.core.enums.SettingsMode;
import com.jmi.jobseekerapi.core.enums.SettingsType;
import lombok.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SharedSettingsRequest {
    @NotNull
    private String name;

    @NotNull
    private String type;

//    @Valid
    @NotNull
    private SharedSettings settings;

    @JsonProperty("default")
    private boolean isDefault;

    private String description;
}
