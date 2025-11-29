package com.jmi.jobseekerapi.exception;


public class InsightfulServerException extends InsightfulApiException {
    public InsightfulServerException(String message, int statusCode) {
        super(message, statusCode);
    }
}