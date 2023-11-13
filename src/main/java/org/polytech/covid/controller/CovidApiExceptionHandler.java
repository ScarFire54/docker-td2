package org.polytech.covid.controller;

import org.polytech.covid.exception.CovidApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CovidApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CovidApiException.class)
    public ResponseEntity<String> handleApiException(CovidApiException exception){
        return ResponseEntity.status(exception.getStatusCode()).body(exception.getMessage());
    }
}
