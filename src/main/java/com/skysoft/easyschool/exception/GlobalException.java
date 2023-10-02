package com.skysoft.easyschool.exception;

public class GlobalException extends Exception {

    public GlobalException(String message){
        super(message);
    }

    public GlobalException(Exception exception){
        super(exception);
    }

    public GlobalException(String message, Exception exception){
        super(message, exception);
    }
}
