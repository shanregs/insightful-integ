package com.openjobs.insightful.exception;

import org.springframework.http.HttpStatus;

public class InsightfulNotFoundException extends InsightfulApiException {
    public InsightfulNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND.value());
    }
}