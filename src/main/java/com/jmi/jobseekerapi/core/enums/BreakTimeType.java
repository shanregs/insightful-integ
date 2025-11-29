package com.jmi.jobseekerapi.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BreakTimeType {
    DISABLED, BASIC;

    @JsonValue
    public String toValue() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static BreakTimeType from(String v) {
        if (v == null) return null;
        return BreakTimeType.valueOf(v.trim().toUpperCase());
    }
}