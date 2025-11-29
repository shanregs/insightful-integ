package com.jmi.jobseekerapi.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum WindowType {
    MANUAL, TRACKED;

    @JsonCreator
    public static WindowType from(String v) {
        if (v == null) return null;
        return WindowType.valueOf(v.trim().toUpperCase());
    }
}
