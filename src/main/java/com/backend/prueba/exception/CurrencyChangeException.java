package com.backend.prueba.exception;

/**
 * @Author: Omar Corahua
 * @FileName: CurrencyChangeException.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */
public class CurrencyChangeException extends RuntimeException{
    public CurrencyChangeException(String message){
        super(message);
    }
}
