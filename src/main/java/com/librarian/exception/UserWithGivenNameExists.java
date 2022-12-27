package com.librarian.exception;

public class UserWithGivenNameExists extends Exception {
    public UserWithGivenNameExists(String message) {
        super(message);
    }
}
