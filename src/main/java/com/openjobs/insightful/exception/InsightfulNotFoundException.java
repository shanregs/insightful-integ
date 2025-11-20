package com.openjobs.insightful.exception;

public class InsightfulNotFoundException extends InsightfulApiException {
    public InsightfulNotFoundException(String message) {
        super(message, 404);
    }
}