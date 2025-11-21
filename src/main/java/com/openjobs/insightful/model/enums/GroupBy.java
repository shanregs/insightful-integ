package com.openjobs.insightful.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum GroupBy {
    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    EMPLOYEE("employee"),
    TEAM("team"),
    SHIFT("shift"),
    TASK("task"),
    PROJECT("project"),
    WINDOW("window");

    private final String value;

    GroupBy(String value) {
        this.value = value;
    }

    @JsonCreator
    public static GroupBy fromValue(String value) {
        for (GroupBy type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid GroupBy: " + value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}