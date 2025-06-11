package com.ohgiraffers.springmvcpractice.RJW;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

// 전역 예외 처리 담당
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String handleNullpointerException(NullPointerException exception, Model model) {
        Map<String, String> exceptionData = new HashMap<>();
        exceptionData.put("message", exception.getMessage());

        model.addAttribute("exception", exceptionData);
        return "RJW/error/exception";
    }
}
