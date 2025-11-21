package com.openjobs.insightful.model.enums;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum ApplicationType {
    APP,       // desktop application
    SITE  ;     // website

    @JsonCreator
    public static ApplicationType from(String v) {
        if (v == null) return null;
        return ApplicationType.valueOf(v.trim().toUpperCase());
    }
}