package com.inditex.controlleradvice;

import org.springframework.data.repository.support.QueryMethodParameterConversionException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse errorResponse =
                new ErrorResponse("Resource not found", ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(QueryMethodParameterConversionException.class)
    public ResponseEntity<ErrorResponse> handleInvalidArgumentException(QueryMethodParameterConversionException ex) {

        ErrorResponse errorResponse =
                new ErrorResponse("Invalid argument", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    public record ErrorResponse(String error, String message, int status) {
    }

}
