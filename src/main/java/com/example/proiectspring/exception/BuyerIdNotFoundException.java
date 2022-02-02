package com.example.proiectspring.exception;

public class BuyerIdNotFoundException extends RuntimeException {
    public BuyerIdNotFoundException(){
        super("Buyer Id not found.");
    }
}
