package com.amil.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;

public class ErrorDetails{
    public ErrorDetails(LocalDate timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ErrorDetails() {
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    private LocalDate timestamp;
    private String message;
    private String details;
}
