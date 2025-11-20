package com.openjobs.insightful.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents each validation issue in the 'details' array
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrorDetail {

    private String type;
    private Integer expected;
    private Integer actual;
    private String field;
    private String message;
}
