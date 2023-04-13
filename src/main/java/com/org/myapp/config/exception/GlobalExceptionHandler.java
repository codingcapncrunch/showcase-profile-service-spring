package com.org.myapp.config.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {AppException.class})
    public ResponseEntity<Object> handleAppException(AppException ex){
        if (ex.getInternalMessage()!=null){
            log.error("ErrorCode: {}, AppException: {}, status: {}, internal message: {}", ex.getExceptionEnum().name(), ex.getUserMessage(), ex.getStatus().toString(), ex.getInternalMessage());
        } else {
            log.error("ErrorCode: {}, AppException: {}, status: {}", ex.getExceptionEnum().name(), ex.getUserMessage(), ex.getStatus().toString());
        }
        return new ResponseEntity<>(ex.getAppExceptionBody(), ex.getStatus());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleMethodArguementNotValidException(MethodArgumentNotValidException ex){
        AppException appException = new AppException(ExceptionEnum.PR1003);
        if (ex.getBindingResult()!=null && ex.getBindingResult().getAllErrors()!=null && !ex.getBindingResult().getAllErrors().isEmpty() && StringUtils.hasLength(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage())) {
            appException.setUserMessage(appException.getUserMessage() + "; " + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        }
        log.error("ErrorCode: {}, AppException: {}", appException.getExceptionEnum().name(), appException.getUserMessage());
        return new ResponseEntity<>(appException.getAppExceptionBody(), appException.getStatus());
    }


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception ex){
        AppException appException = new AppException(ExceptionEnum.PR5000);
        log.error("ErrorCode: {}, Unknown exception message: {}, ex stacktrace: {}", appException.getExceptionEnum().name(), ex.getMessage(), ex.toString());
        return new ResponseEntity<>(appException.getAppExceptionBody(), appException.getStatus());
    }


}
