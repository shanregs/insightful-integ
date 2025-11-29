package com.jmi.jobseekerapi.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductivityType {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3);

    private final int value;

    public static ProductivityType fromValue(int value) {
        for (ProductivityType type : values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
