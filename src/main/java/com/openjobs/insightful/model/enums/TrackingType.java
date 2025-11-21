package com.openjobs.insightful.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum TrackingType {
    UNLIMITED("unlimited"),
    LIMITED("limited"),
    NETWORK("network"),
    PROJECT("project"),
    MANUAL("manual");

    private final String value;

    TrackingType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static TrackingType fromValue(String value) {
        for (TrackingType type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid TrackingType: " + value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
