package com.example.proiectspring.exception;

public class JewelryIdNotFoundExeception extends  RuntimeException{

    public JewelryIdNotFoundExeception(){
        super("Jewelry with this Id was not found!");
    }
}
