package com.openjobs.insightful.exception;


public class InsightfulServerException extends InsightfulApiException {
    public InsightfulServerException(String msg, int code) {
        super(msg, code);
    }
}