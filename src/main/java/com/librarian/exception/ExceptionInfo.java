package com.librarian.exception;

public enum ExceptionInfo {
    USER_WITH_GIVEN_NAME_EXISTS("Given name is registered in our system. There can be only one account registered to given email.");

    private String message;

    ExceptionInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
