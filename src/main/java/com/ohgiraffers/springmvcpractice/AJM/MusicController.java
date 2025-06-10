package com.ohgiraffers.springmvcpractice.AJM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MusicController {

    @RequestMapping(value ={"/", "/main"})
    public String main() {

        return "AJM/main";
    }

    @GetMapping("search")
    public String searchTest() throws NullPointException{

        if()

        return "/";
    }

    @GetMapping("enroll")
    public String enrollTest() throws MusicRegistException{

        boolean check
    }
}
