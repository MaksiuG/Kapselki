package com.kapselki.Exceptions;

public class CreatingClientException extends RuntimeException{
    public CreatingClientException() {
        super("Impossible to create a Client, check if data are valid");
    }
}
