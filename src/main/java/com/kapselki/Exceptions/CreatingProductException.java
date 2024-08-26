package com.kapselki.Exceptions;

public class CreatingProductException extends RuntimeException{
    public CreatingProductException() {
        super(
                "Error while creating product, check if data are valid"
        );
    }
}
