package com.jmi.jobseekerapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class InsightfulExceptionHandler {

    private Map<String, Object> buildError(int status, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now().toString());
        body.put("status", status);
        body.put("error", HttpStatus.valueOf(status).getReasonPhrase());
        body.put("message", message);
        return body;
    }



    // 400 - Validation Error
    @ExceptionHandler(InsightfulValidationException.class)
    public ResponseEntity<?> handleValidation(InsightfulValidationException ex) {

        log.warn("Validation Error → {}", ex.getMessage());

        Map<String, Object> body = buildError(400, ex.getMessage());
        body.put("details", ex.getValidationDetails());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    // 401
    @ExceptionHandler(InsightfulUnauthorizedException.class)
    public ResponseEntity<?> handleUnauthorized(InsightfulUnauthorizedException ex) {
        log.warn("Unauthorized → {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(buildError(HttpStatus.UNAUTHORIZED.value(), ex.getMessage()));
    }

    // 404
    @ExceptionHandler(InsightfulNotFoundException.class)
    public ResponseEntity<?> handleNotFound(InsightfulNotFoundException ex) {
        log.warn("Not Found → {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(buildError(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    // 409
    @ExceptionHandler(DuplicateTeamException.class)
    public ResponseEntity<?> handleDuplicateTeam(DuplicateTeamException ex) {
        log.warn("Duplicate Conflict → {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(buildError(HttpStatus.CONFLICT.value(), ex.getMessage()));
    }

    @ExceptionHandler(EmployeeAlreadyDeactivatedException.class)
    public ResponseEntity<?> handleEmployeeAlreadyDeactivated(EmployeeAlreadyDeactivatedException ex) {
        InsightfulConflictError err = new InsightfulConflictError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    // 500–504
    @ExceptionHandler(InsightfulServerException.class)
    public ResponseEntity<?> handleServerError(InsightfulServerException ex) {
        log.error("Insightful Server Error → {}", ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode())
                .body(buildError(ex.getStatusCode(), ex.getMessage()));
    }

    // Other Insightful API errors
    @ExceptionHandler(InsightfulApiException.class)
    public ResponseEntity<?> handleApi(InsightfulApiException ex) {
        log.warn("Insightful API Error → {}", ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode())
                .body(buildError(ex.getStatusCode(), ex.getMessage()));
    }

    // Fallback → internal server error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneric(Exception ex) {
        log.error("Unexpected error", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(buildError(500, "Unexpected server error: " + ex.getMessage()));
    }
}
