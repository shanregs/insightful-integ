package com.openjobs.insightful.exception;

public class InsightfulApiException extends RuntimeException {
    private final int status;

    public InsightfulApiException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
