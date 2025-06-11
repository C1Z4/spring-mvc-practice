package com.ohgiraffers.springmvcpractice.KSE;

import com.ohgiraffers.springmvcpractice.common.MusicDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {

    // 1. forward 방식으로 등록되어 있는 음악 조회
    @PostMapping("forward")
    public String selectMusic(@ModelAttribute("music") MusicDTO musicDTO) throws MusicSearchException {

        // 가수 이름이 "투바투"와 일치하는 경우 MusicSearchException 발생
        if (musicDTO.getSinger().equals("투바투")) {
            throw new MusicSearchException(musicDTO.getSinger() + "가 없습니다.");
        }

        return "KSE/view/result";
    }

    // 3-1. 해당하는 가수 없을 때 예외처리
    @ExceptionHandler(MusicSearchException.class)
    public String musicSearchException(Model model, MusicSearchException exception) {
        model.addAttribute("exception", exception);

        return "KSE/error/musicSearchException";
    }

    // 2. redirect 방식으로 음악 등록하기
    // 이미 등록되어 있다고 가정하고 alert 띄우기
    @PostMapping("redirect")
    public String registMusice(RedirectAttributes rttr, @RequestParam String title, @RequestParam String singer) {
        String flashMessage = title + "은(는) 이미 등록되어 있습니다.";
        rttr.addFlashAttribute("flashMessage", flashMessage);

        // title과 singer가 빈 문자열인 경우 NullPointerException 발생
        if (title == null || singer == null || title.isBlank() || singer.isBlank()) {
            throw new NullPointerException("음악과 이름은 필수 항목입니다.");
        }
        return "redirect:/";
    }
}
