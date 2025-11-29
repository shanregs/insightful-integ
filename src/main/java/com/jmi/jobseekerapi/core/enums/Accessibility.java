package com.jmi.jobseekerapi.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Accessibility {
    AUTHORIZED, DENIED, UNDETERMINED;

    @JsonCreator
    public static Accessibility from(String v) {
        if (v == null) return null;
        return Accessibility.valueOf(v.trim().toUpperCase());
    }
}
