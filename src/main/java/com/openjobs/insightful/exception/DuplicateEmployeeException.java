package com.openjobs.insightful.exception;

public class DuplicateEmployeeException extends InsightfulApiException {
    public DuplicateEmployeeException(String message) {
        super(message, 409);
    }
}