package com.org.myapp.config.exception;

import org.springframework.http.HttpStatus;

public enum ExceptionEnum {

    PR5000("Unknown exception", HttpStatus.INTERNAL_SERVER_ERROR),
    PR1000("Profile not found", HttpStatus.NOT_FOUND),
    PR1001("Invalid profile ID", HttpStatus.BAD_REQUEST),
    PR1002("Profile must have a first and last name", HttpStatus.BAD_REQUEST),
    PR1003("dto invalid", HttpStatus.BAD_REQUEST);

    public final String message;
    public final HttpStatus httpStatus;

    ExceptionEnum(String message, HttpStatus status) {
        this.message = message;
        this.httpStatus = status;
    }

    public String getMessage(){
        return this.message;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
