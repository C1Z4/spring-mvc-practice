package com.ohgiraffers.springmvcpractice.KSE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/main"})
    public String main() {
        return "KSE/main";
    }
}
