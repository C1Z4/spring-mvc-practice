package com.ohgiraffers.springmvcpractice.YJE;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MusicExceptionController {

    @ExceptionHandler(MusicSearchException.class)
    public String musicSearchException(MusicSearchException exception, Model model) {

        model.addAttribute("exception", exception);

        return "YJE/error/exception";
    }


}
