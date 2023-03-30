package com.org.myapp.config.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {AppException.class})
    public ResponseEntity<Object> handleAppException(AppException ex){
        if (ex.getInternalMessage()!=null){
            log.error("AppException: {}, status: {}, internal message: {}", ex.getUserMessage(), ex.getStatus().toString(), ex.getInternalMessage());
        } else {
            log.error("AppException: {}, status: {}", ex.getUserMessage(), ex.getStatus().toString());
        }
        return new ResponseEntity<>(ex.getAppExceptionBody(), ex.getStatus());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception ex){
        AppException appException = new AppException(ExceptionEnum.PR5000);
        log.error("Unknown exception message: {}, ex stacktrace: {}", ex.getMessage(), ex.toString());
        return new ResponseEntity<>(appException.getAppExceptionBody(), appException.getStatus());
    }


}
