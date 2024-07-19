package com.springBasics.Transaction_Management.exceptions;

public class InsufficientFundsException extends Exception{

    public InsufficientFundsException(String message){
        super(message);
    }
}
