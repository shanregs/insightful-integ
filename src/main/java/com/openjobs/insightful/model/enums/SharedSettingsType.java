package com.openjobs.insightful.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SharedSettingsType {
    OFFICE, PERSONAL;

    @JsonCreator
    public static SharedSettingsType from(String v) {
        if (v == null) return null;
        return SharedSettingsType.valueOf(v.trim().toUpperCase());
    }
}
