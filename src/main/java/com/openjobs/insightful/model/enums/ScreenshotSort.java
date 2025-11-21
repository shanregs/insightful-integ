package com.openjobs.insightful.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum ScreenshotSort {
    PRODUCTIVITY("productivity"),
    NAME("name"),
    USER("user"),
    APP("app"),
    TITLE("title"),
    URL("url"),
    SHIFT_ID("shiftId"),
    PROJECT_ID("projectId"),
    TASK_ID("taskId"),
    WINDOW_ID("windowId"),
    APP_ORG_ID("appOrgId"),
    APP_TEAM_ID("appTeamId"),
    EMPLOYEE_ID("employeeId"),
    TEAM_ID("teamId");

    private final String value;

    ScreenshotSort(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ScreenshotSort fromValue(String value) {
        for (ScreenshotSort type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid ScreenshotSort: " + value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}