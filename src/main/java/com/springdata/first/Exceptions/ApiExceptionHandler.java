/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springdata.first.Exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author lenovo
 */
public class ApiExceptionHandler {
    
    @ExceptionHandler(value = {ApiRequestException.class})
    
    public ResponseEntity <Object> handleApiRequestException (ApiRequestException e) {
        
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
            e.getMessage(),
            e,
            badRequest,
            ZonedDateTime.now(ZoneId.of("Z"))
        );
            return new ResponseEntity<>(apiException,badRequest);
    }
    
}
