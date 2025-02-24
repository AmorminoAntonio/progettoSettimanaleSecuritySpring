package com.example.springSecurityWeekProject.exceptions;

public class EmailDuplicated extends RuntimeException {
    public EmailDuplicated(String message) {
        super(message);
    }
}
