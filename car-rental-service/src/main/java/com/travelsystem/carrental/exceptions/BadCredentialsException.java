package com.travelsystem.carrental.exceptions;

public class BadCredentialsException extends RuntimeException {

    public BadCredentialsException(String message){
        super(message);
    }
}
