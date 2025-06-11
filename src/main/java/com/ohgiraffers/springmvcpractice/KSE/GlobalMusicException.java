package com.ohgiraffers.springmvcpractice.KSE;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;

@ControllerAdvice
public class GlobalMusicException {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointException() {
        return "KSE/error/nullPointException";
    }
}
