package com.ohgiraffers.springmvcpractice.RJW;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String main() {
        return "RJW/main";
    }
}
