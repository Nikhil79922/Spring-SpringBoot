package com.example.CRUDops.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionDto {
    private boolean success;
    private String message;
    private LocalDateTime timestamp;
    private int status;
    private String path;
    private Map<String,String> fieldsErrors;

    public ValidationExceptionDto(boolean success, String message, LocalDateTime timestamp, int status, String path , Map fieldsErrors) {
        this.success = success;
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
        this.fieldsErrors = fieldsErrors;
    }

    public Map<String, String> getFieldsErrors() {
        return fieldsErrors;
    }

    public void setFieldsErrors(Map<String, String> fieldsErrors) {
        this.fieldsErrors = fieldsErrors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
