package com.jmi.jobseekerapi.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmi.jobseekerapi.core.SharedSettings;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
