package com.openjobs.insightful.dto.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SettingsMode {
    UNLIMITED, MANUAL;

    @JsonCreator
    public static SettingsMode from(String v) {
        if (v == null) return null;
        return SettingsMode.valueOf(v.trim().toUpperCase());
    }
}
