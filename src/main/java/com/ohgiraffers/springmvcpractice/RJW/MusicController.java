package com.ohgiraffers.springmvcpractice.RJW;

import com.ohgiraffers.springmvcpractice.common.MusicDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {

    // 조회
    @GetMapping("selectMusic")
    public String selectMusic(@ModelAttribute("music") MusicDTO music) throws NullPointerException {
        if ("빅뱅".equals(music.getSinger())) {
            throw new NullPointerException("해당 가수(" + music.getSinger() + ")는 없습니다...");
        }
        return "RJW/view/result";
    }

    // 등록
    @PostMapping("registerMusic")
    public String registerMusic(@ModelAttribute("music") MusicDTO music, RedirectAttributes rttr)
            throws MusicRegistException {

        if ("".equals(music.getTitle()) || "".equals(music.getSinger())) {
            throw new MusicRegistException("음악 이름과 가수는 필수 입력 항목입니다.");
        }

        rttr.addFlashAttribute("flashMessage", music.getTitle() + "은 이미 등록되어있습니다.");

        return "redirect:/";
    }

    @ExceptionHandler(MusicRegistException.class)
    public String musicRegistException(MusicRegistException exception, Model model) {

        model.addAttribute("exception", exception);

        return "RJW/error/exception";
    }

}
