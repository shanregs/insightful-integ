package com.openjobs.insightful.exception;


public class InsightfulNotFoundException extends InsightfulApiException {
    public InsightfulNotFoundException(String msg) {
        super(msg, 404);
    }
}