package com.ticketbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class ExceptionTranslator extends ResponseEntityExceptionHandler {

    private ExceptionResponse prepareErrorResponse(String error) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(error);
        exceptionResponse.setTime(LocalDateTime.now());
        return exceptionResponse;
    }

    @ExceptionHandler(AccountAlradyExistException.class)
    public ResponseEntity<?> handlingAccountAlradyExistException(AccountAlradyExistException exception, WebRequest request) {
        ExceptionResponse exceptionResponse = prepareErrorResponse(exception.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SomthingIsWorngException.class)
    public ResponseEntity<?> handlingSomthingIsWorngException(SomthingIsWorngException exception, WebRequest request) {
        ExceptionResponse exceptionResponse = prepareErrorResponse(exception.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> handlingDataNotFoundException(DataNotFoundException exception, WebRequest request) {
        ExceptionResponse exceptionResponse = prepareErrorResponse(exception.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(VerificationCodeMismatchException.class)
    public ResponseEntity<?> handlingVerificationCodeMismatchException(VerificationCodeMismatchException exception,WebRequest request){
        ExceptionResponse exceptionResponse = prepareErrorResponse(exception.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
