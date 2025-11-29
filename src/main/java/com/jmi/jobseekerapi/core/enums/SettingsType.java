package com.jmi.jobseekerapi.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum SettingsType {
    PERSONAL("personal"),
    OFFICE("office");

    private final String value;

    SettingsType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static SettingsType fromValue(String value) {
        for (SettingsType type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid SettingsType: " + value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
