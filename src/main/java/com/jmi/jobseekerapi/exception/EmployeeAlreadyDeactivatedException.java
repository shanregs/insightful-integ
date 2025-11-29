package com.jmi.jobseekerapi.exception;

public class EmployeeAlreadyDeactivatedException extends InsightfulApiException {
    public EmployeeAlreadyDeactivatedException(String message) {
        super(message, 409);
    }
}