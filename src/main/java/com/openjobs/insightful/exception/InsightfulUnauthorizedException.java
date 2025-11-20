package com.openjobs.insightful.exception;


public class InsightfulUnauthorizedException extends InsightfulApiException {
    public InsightfulUnauthorizedException(String msg) {
        super(msg, 401);
    }
}