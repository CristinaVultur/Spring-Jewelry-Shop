package com.example.proiectspring.exception;

public class CartIdNotFoundException extends RuntimeException {

    public CartIdNotFoundException(){
        super("Shopping cart Id not found.");
    }
}
