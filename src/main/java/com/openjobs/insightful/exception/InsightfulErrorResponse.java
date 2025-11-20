package com.openjobs.insightful.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents any API error returned by Insightful.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsightfulErrorResponse {
    private String type;
    private String message;
    private List<ValidationErrorDetail> details; // optional
}
