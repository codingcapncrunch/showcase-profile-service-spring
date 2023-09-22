package com.org.myapp.config.exception;

import org.springframework.http.HttpStatus;

public enum ExceptionEnum {

    //profile errors
    PR5000("Unknown exception", HttpStatus.INTERNAL_SERVER_ERROR),
    PR1000("Profile not found", HttpStatus.NOT_FOUND),
    PR1001("Invalid profile ID", HttpStatus.BAD_REQUEST),
    PR1002("Profile must have a first and last name", HttpStatus.BAD_REQUEST),
    PR1003("dto invalid", HttpStatus.BAD_REQUEST),
    PR1004("Invalid search request", HttpStatus.BAD_REQUEST),
    PR1005("Update timestamp does not match - dirty write", HttpStatus.BAD_REQUEST),

    //address errors
    AD1000("Invalid address validation request", HttpStatus.BAD_REQUEST),
    AD1001("Unknown address city", HttpStatus.BAD_REQUEST),
    AD1002("Unknown address state", HttpStatus.BAD_REQUEST),
    AD1003("Unknown address zipcode", HttpStatus.BAD_REQUEST),
    AD1004("Unknown address city for state", HttpStatus.BAD_REQUEST),
    AD1005("Unknown address zipcode for state", HttpStatus.BAD_REQUEST),
    AD1006("Address line two cannot be empty/null", HttpStatus.BAD_REQUEST),

    //contactus
    CU1000("ContactUs save error", HttpStatus.INTERNAL_SERVER_ERROR),
    CU1001("ContactUs request not found", HttpStatus.NOT_FOUND);

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
