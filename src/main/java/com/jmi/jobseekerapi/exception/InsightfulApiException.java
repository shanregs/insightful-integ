package com.jmi.jobseekerapi.exception;

import lombok.Getter;

@Getter
public class InsightfulApiException extends RuntimeException {
    private final int statusCode;

    public InsightfulApiException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}