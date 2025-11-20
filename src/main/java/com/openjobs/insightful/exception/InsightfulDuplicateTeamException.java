package com.openjobs.insightful.exception;


public class InsightfulDuplicateTeamException extends InsightfulApiException {
    public InsightfulDuplicateTeamException(String msg) {
        super(msg, 409);
    }
}