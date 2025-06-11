package com.ohgiraffers.springmvcpractice.HJH;


import com.ohgiraffers.springmvcpractice.common.MusicDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {

    // 1. forward 방식으로 등록되어 있는 음악 조회
    @PostMapping("search") //
    public String searchMusic (@ModelAttribute("music") MusicDTO music) throws MusicSearchException{

        return "HJH/view/result";

    }


    // 2. redirect 방식으로 음악 등록하기
    @PostMapping("register")
    public String registerMusic (RedirectAttributes rttr,
                                 @RequestParam String title,
                                 @RequestParam String singer) {

        String flashMessage = title + "및" + singer +"은(는) 이미 등록 되어 있습니다.";
        rttr.addFlashAttribute("flashMessage", flashMessage);

        return "redirect:/";

    }

}
