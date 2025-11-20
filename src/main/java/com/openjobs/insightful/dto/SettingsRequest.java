package com.openjobs.insightful.dto;


import lombok.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettingsRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @Valid
    @NotNull
    private Settings settings;
}
