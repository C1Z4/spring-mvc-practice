package com.ohgiraffers.springmvcpractice.AJM;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(MusicSearchException.class)
    public String musicSearchException(MusicSearchException exception, Model model) {
        model.addAttribute("exception", exception);
        return "AJM/error/exception";
    }

    @ExceptionHandler(MusicEnrollException.class)
    public String musicEnrollException(MusicEnrollException exception, Model model) {
        model.addAttribute("exception", exception);
        return "AJM/error/exception";
    }

}
