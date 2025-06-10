package com.ohgiraffers.springmvcpractice.AJM;

import com.ohgiraffers.springmvcpractice.common.MusicDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicExceptionController {

    //1. forward
    //등록되어 있는 음악 조회하기
    //조회 목록 : 음악 이름, 작곡가, 작사가, 가수, 장르
    @PostMapping("search")
    public String searchMusic(@ModelAttribute("music")MusicDTO music) {



        return "AJM/view/result";

    }

    //
    @GetMapping("enroll")
    public String enrollMusic(RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("flashMessage","${title}은 이미 등록되어있습니다.");

        return "redirect:/";

    }

    //
//    @ExceptionHandler(MusicException.class)
//    public String
}
