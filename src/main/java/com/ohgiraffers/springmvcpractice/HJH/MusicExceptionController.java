package com.ohgiraffers.HJH;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicExceptionController {

    @GetMapping("controller-null")
    public String nullPointerExceptionTest() {

        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception) {

        System.out.println("controller 레벨의 exception 처리");

        return "error/exception";
    }

    @GetMapping("controller-user")
    public String userExceptionTest() throws MusicRegistException {

        boolean check = true;
        if(check) {
            throw new MusicRegistException("당신 같은 사람은 회원으로 받을 수 없습니다.");
        }

        return "/";
    }

    @ExceptionHandler(MusicRegistException.class)
    public String userExceptionHandler(Model model, MusicRegistException exception) {

        System.out.println("controller 레벨의 exception 처리");
        model.addAttribute("exception", exception);

        return "error/exception";
    }


}
