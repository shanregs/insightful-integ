package com.openjobs.insightful.utils;

// ===============================================
//  ResponseUtil.java (for REST controllers)
// ===============================================
/**
 * Utility class for creating standardized HTTP responses.
 * Status	Method
 * 200 		OK						ok(), ok(body)
 * 201 		Created					created(location, body)
 * 202 		Accepted				accepted()
 * 204 		No Content				noContent()
 * 400 		Bad Request				badRequest(msg)
 * 401 		Unauthorized			unauthorized()
 * 403 		Forbidden				forbidden(msg)
 * 404 		Not Found				notFound() / notFound(msg)
 * 409 		Conflict				conflict(msg)
 * 422 		Unprocessable Entity	unprocessableEntity(msg)
 * 429 		Too Many Requests		tooManyRequests()
 * 500 		Internal Server Error	internalServerError(msg)
 * 502 		Bad Gateway				badGateway()
 * 503 		Service Unavailable		serviceUnavailable()
 */
// ===============================================
// ResponseUtil.java – The FINAL version (2025)
// Covers ALL real-world HTTP statuses + fluent API
// ===============================================

import org.springframework.http.*;
import java.net.URI;
import java.time.LocalDateTime;

public final class ResponseUtil {

    private ResponseUtil() {}

    // ===================================================================
    // 1. Success responses (2xx)
    // ===================================================================
    public static <T> ResponseEntity<T> ok(T body) {
        return ResponseEntity.ok(body);
    }

    public static ResponseEntity<Void> ok() {
        return ResponseEntity.ok().build();
    }

    public static <T> ResponseEntity<T> created(String location, T body) {
        return ResponseEntity.created(URI.create(location)).body(body);
    }

    public static ResponseEntity<Void> created(String location) {
        return ResponseEntity.created(URI.create(location)).build();
    }

    public static ResponseEntity<Void> noContent() {
        return ResponseEntity.noContent().build();
    }

    public static <T> ResponseEntity<T> accepted(T body) {
        return ResponseEntity.accepted().body(body);
    }

    public static ResponseEntity<Void> accepted() {
        return ResponseEntity.accepted().build();
    }

    // ===================================================================
    // 2. Client errors (4xx)
    // ===================================================================
    public static ResponseEntity<ApiError> badRequest(String message) {
        return badRequest(message, null);
    }

    public static ResponseEntity<ApiError> badRequest(String message, String detail) {
        return ResponseEntity.badRequest()
                .body(new ApiError("Bad Request", message, detail, LocalDateTime.now()));
    }

    public static ResponseEntity<Void> unauthorized() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    public static ResponseEntity<ApiError> forbidden(String message) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ApiError("Forbidden", message, null, LocalDateTime.now()));
    }

    public static ResponseEntity<Void> notFound() {
        return ResponseEntity.notFound().build();
    }

    public static ResponseEntity<ApiError> notFound(String message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError("Not Found", message, null, LocalDateTime.now()));
    }

    public static ResponseEntity<ApiError> conflict(String message) {
        return conflict(message, null);
    }

    public static ResponseEntity<ApiError> conflict(String message, String detail) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiError("Conflict", message, detail, LocalDateTime.now()));
    }

    public static ResponseEntity<ApiError> unprocessableEntity(String message) {
        return unprocessableEntity(message, null);
    }

    public static ResponseEntity<ApiError> unprocessableEntity(String message, String detail) {
        return ResponseEntity.unprocessableEntity()
                .body(new ApiError("Unprocessable Entity", message, detail, LocalDateTime.now()));
    }

    public static ResponseEntity<ApiError> tooManyRequests() {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .body(new ApiError("Too Many Requests", "Rate limit exceeded", null, LocalDateTime.now()));
    }

    // ===================================================================
    // 3. Server errors (5xx)
    // ===================================================================
    public static ResponseEntity<ApiError> internalServerError(String message) {
        return internalServerError(message, null);
    }

    public static ResponseEntity<ApiError> internalServerError(String message, String detail) {
        return ResponseEntity.internalServerError()
                .body(new ApiError("Internal Server Error", message, detail, LocalDateTime.now()));
    }

    public static ResponseEntity<ApiError> serviceUnavailable() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new ApiError("Service Unavailable", "Please try again later", null, LocalDateTime.now()));
    }

    public static ResponseEntity<ApiError> badGateway() {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body(new ApiError("Bad Gateway", "Upstream service error", null, LocalDateTime.now()));
    }

    // ===================================================================
    // 4. Generic reusable error builder
    // ===================================================================
    public static ResponseEntity<ApiError> error(HttpStatus status, String message) {
        return error(status, message, null);
    }

    public static ResponseEntity<ApiError> error(HttpStatus status, String message, String detail) {
        return ResponseEntity.status(status)
                .body(new ApiError(status.getReasonPhrase(), message, detail, LocalDateTime.now()));
    }

    // ===================================================================
    // 5. Enhanced ApiError record (with status code)
    // ===================================================================
    public record ApiError(
            String error,
            String message,
            String detail,
            LocalDateTime timestamp,
            Integer status // optional – for clients that prefer numeric code
    ) {
        public ApiError(String error, String message, String detail, LocalDateTime timestamp) {
            this(error, message, detail, timestamp, null);
        }

        // Helper for setting status if needed
        public ApiError withStatus(int status) {
            return new ApiError(this.error, this.message, this.detail, this.timestamp, status);
        }
    }

    // ===================================================================
    // 6. Bonus: Wrap any object with specific status
    // ===================================================================
    public static <T> ResponseEntity<T> status(HttpStatus status, T body) {
        return ResponseEntity.status(status).body(body);
    }

    public static ResponseEntity<Void> status(HttpStatus status) {
        return ResponseEntity.status(status).build();
    }

    // ===================================================================
    // 7. With headers (common use cases)
    // ===================================================================
    public static <T> ResponseEntity<T> okWithHeader(T body, String headerName, String headerValue) {
        return ResponseEntity.ok().header(headerName, headerValue).body(body);
    }

    public static ResponseEntity<Void> noContentWithLocation(String location) {
        return ResponseEntity.noContent().location(URI.create(location)).build();
    }
}