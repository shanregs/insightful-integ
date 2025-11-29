package com.jmi.jobseekerapi.exception;

public class DuplicateEmployeeException extends InsightfulApiException {
    public DuplicateEmployeeException(String message) {
        super(message, 409);
    }
}