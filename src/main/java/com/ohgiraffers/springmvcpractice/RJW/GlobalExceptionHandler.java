package com.ohgiraffers.springmvcpractice.RJW;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 전역 예외 처리 담당
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MusicSearchException.class)
    public String handleMusicSearchException(MusicSearchException exception, Model model) {

        model.addAttribute("exception", exception);
        return "RJW/error/exception";
    }
}
