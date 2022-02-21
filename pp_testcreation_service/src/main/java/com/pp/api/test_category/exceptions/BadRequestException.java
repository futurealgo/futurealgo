package com.pp.api.test_category.exceptions;

public class BadRequestException extends RuntimeException{

    private int code;
    private String message;

    public BadRequestException(){
        super("Bad Request");
    }

    public BadRequestException(int code, String message){
        super(message);
    }
}
