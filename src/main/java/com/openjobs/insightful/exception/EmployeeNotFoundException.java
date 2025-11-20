package com.openjobs.insightful.exception;


public class EmployeeNotFoundException extends InsightfulApiException {
    public EmployeeNotFoundException(String message) {
        super(message, 404);
    }
}