package com.example.CRUDops.dto;

import java.time.LocalDateTime;

public class ExceptionValidationDTO {
    private boolean success;
    private String message;
    private LocalDateTime timestamp;
    private int status;
    private String path;

    public ExceptionValidationDTO(boolean success, String message, LocalDateTime timestamp, int status, String path) {
        this.success = success;
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
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
