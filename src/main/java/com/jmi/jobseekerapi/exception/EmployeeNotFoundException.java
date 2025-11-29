package com.jmi.jobseekerapi.exception;


public class EmployeeNotFoundException extends InsightfulNotFoundException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}