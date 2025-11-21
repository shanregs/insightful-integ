package com.openjobs.insightful.exception;

import org.springframework.http.HttpStatus;

public class InsightfulUnauthorizedException extends InsightfulApiException {
    public InsightfulUnauthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED.value());
    }
    public InsightfulUnauthorizedException(String message, int statusCode) {
        super(message, statusCode);
    }
}