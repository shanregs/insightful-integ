package com.openjobs.insightful.exception;

public class InsightfulUnauthorizedException extends InsightfulApiException {
    public InsightfulUnauthorizedException(String message) {
        super(message, 401);
    }
}