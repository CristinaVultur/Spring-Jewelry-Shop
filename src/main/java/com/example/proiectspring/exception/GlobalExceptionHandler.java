package com.example.proiectspring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({DistributorNameNotFoundException.class,  JewelryIdNotFoundExeception.class,
    BuyerIdNotFoundException.class, CartIdNotFoundException.class})
    public ResponseEntity handle(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
