package com.ohgiraffers.springmvcpractice.AJM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value={"/","/main"})
    public String main() {
        return "AJM/main";
    }
}
