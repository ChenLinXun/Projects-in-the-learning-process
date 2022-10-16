package com.feng.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web controller的异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有controller的数学运算异常和空指针异常
     */
    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String handleException(){
        return "err1";
    }
}
