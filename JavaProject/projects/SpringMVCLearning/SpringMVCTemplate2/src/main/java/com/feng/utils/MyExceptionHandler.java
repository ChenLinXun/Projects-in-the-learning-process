package com.feng.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(NumberFormatException.class)
    public String formatHandler(){
        return "err1";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullHandler(){
        return "err2";
    }
}
