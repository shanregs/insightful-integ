package com.openjobs.insightful.exception;
import java.util.List;
import java.util.Map;

public class InsightfulValidationException extends InsightfulApiException {

    private final List<Map<String, Object>> validationDetails;

    public InsightfulValidationException(String message, List<Map<String, Object>> details) {
        super(message, 400);
        this.validationDetails = details;
    }

    public List<Map<String, Object>> getValidationDetails() {
        return validationDetails;
    }
}