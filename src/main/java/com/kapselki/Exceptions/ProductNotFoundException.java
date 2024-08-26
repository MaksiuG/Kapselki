package com.kapselki.Exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long id) {
        super(
                "Client not found, check if ID '"+id+ "' is correct"
        );
    }
}
