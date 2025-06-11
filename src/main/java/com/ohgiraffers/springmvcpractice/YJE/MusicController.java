package com.ohgiraffers.springmvcpractice.YJE;

import com.ohgiraffers.springmvcpractice.common.MusicDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MusicController {

    @RequestMapping(value = {"/", "main"})
    public String main() {

        return "YJE/main";
    }

    @GetMapping("search")
    public String searchMusic(@ModelAttribute MusicDTO music, Model model) throws MusicSearchException {

        if ("박존".equals(music.getSinger())) {
            throw new MusicSearchException(music.getSinger() + "는 존재하지 않습니다.");
        }

        model.addAttribute("music", music);

        return "YJE/view/result";
    }

    @PostMapping("regist")
    public String registMusic(HttpServletRequest request, RedirectAttributes redirectAttributes) throws NullPointerException{
        String title = request.getParameter("r_title");
        String singer = request.getParameter("r_singer");

        if (title == null || singer == null || title.isBlank() || singer.isBlank()) {
            throw new NullPointerException("제목과 가수는 필수값입니다.");
        } else {
            redirectAttributes.addFlashAttribute("flashMessage", title + " 등록 성공!");
        }

        return "redirect:/";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException exception, Model model) {

        Map<String, String> e = new HashMap<>();
        e.put("message", exception.getMessage());

        model.addAttribute("exception", e);

        return "YJE/error/exception";
    }



}
