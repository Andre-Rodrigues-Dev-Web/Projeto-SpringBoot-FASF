package com.fasf.exception;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private Map<String, String> validationErrors;

    public ErrorDetails() {
    }

    public ErrorDetails(LocalDateTime timestamp, String message, String details, Map<String, String> validationErrors) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.validationErrors = validationErrors;
    }

    public static ErrorDetailsBuilder builder() {
        return new ErrorDetailsBuilder();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDetails that = (ErrorDetails) o;
        return Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(message, that.message) &&
                Objects.equals(details, that.details) &&
                Objects.equals(validationErrors, that.validationErrors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, message, details, validationErrors);
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                ", validationErrors=" + validationErrors +
                '}';
    }

    public static class ErrorDetailsBuilder {
        private LocalDateTime timestamp;
        private String message;
        private String details;
        private Map<String, String> validationErrors;

        ErrorDetailsBuilder() {
        }

        public ErrorDetailsBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorDetailsBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorDetailsBuilder details(String details) {
            this.details = details;
            return this;
        }

        public ErrorDetailsBuilder validationErrors(Map<String, String> validationErrors) {
            this.validationErrors = validationErrors;
            return this;
        }

        public ErrorDetails build() {
            return new ErrorDetails(timestamp, message, details, validationErrors);
        }
    }
}
