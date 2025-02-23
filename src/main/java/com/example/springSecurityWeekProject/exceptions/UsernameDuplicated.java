package com.example.springSecurityWeekProject.exceptions;

public class UsernameDuplicated extends RuntimeException {
    public UsernameDuplicated(String message) {
        super(message);
    }
}
