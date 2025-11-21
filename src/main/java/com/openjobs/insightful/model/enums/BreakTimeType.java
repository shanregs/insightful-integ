package com.openjobs.insightful.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum BreakTimeType {
    DISABLED, BASIC;

    @JsonCreator
    public static BreakTimeType from(String v) {
        if (v == null) return null;
        return BreakTimeType.valueOf(v.trim().toUpperCase());
    }
}
