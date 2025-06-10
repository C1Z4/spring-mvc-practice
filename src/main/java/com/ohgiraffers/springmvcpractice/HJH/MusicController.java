package com.ohgiraffers.HJH;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MusicController {

    @GetMapping("search")
    public String searchMusic (Model model) {
        model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환함...");

        return "result";
    }


}
