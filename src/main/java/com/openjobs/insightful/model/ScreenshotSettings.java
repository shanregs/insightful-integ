package com.openjobs.insightful.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ScreenshotSettings {
    @NotNull
    private boolean screenshotEnabled;   // required
}
