package com.jmi.jobseekerapi.exception;

import org.springframework.http.HttpStatus;

public class InsightfulUnauthorizedException extends InsightfulApiException {
    public InsightfulUnauthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED.value());
    }
}