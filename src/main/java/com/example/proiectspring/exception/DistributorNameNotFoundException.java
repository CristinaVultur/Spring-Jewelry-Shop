package com.example.proiectspring.exception;

public class DistributorNameNotFoundException extends RuntimeException {

    public DistributorNameNotFoundException(){
        super("Distributor with that name was not found!");
    }
}
