package com.openjobs.insightful.exception;

public class DuplicateTeamException extends InsightfulApiException {
    public DuplicateTeamException(String message) {
        super(message, 409);
    }
}