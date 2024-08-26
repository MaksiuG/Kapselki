package com.kapselki.Exceptions;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long id) {
        super("Client not found, check if ID '"+id+ "' is correct");
    }
}
