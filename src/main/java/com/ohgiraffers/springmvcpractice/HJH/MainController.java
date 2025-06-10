package com.ohgiraffers.springmvcpractice.HJH;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class MainController {

    @RequestMapping("/")
    public String mainController () {

        return "main";

    }

    @RequestMapping("/main")
    public String mainController2 () {
        return "main";
    }
}

