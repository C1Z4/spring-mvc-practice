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
public class MusicController {

    //등록되어 있는 음악 조회하기
    //조회 목록 : 음악 이름, 작곡가, 작사가, 가수, 장르
    @PostMapping("search")
    public String searchMusic(@ModelAttribute("music")MusicDTO music) throws MusicSearchException{

        if("wish".equals(music.getSinger())){
            throw new MusicSearchException(music.getSinger()+"는 없습니다.");
        }

        return "AJM/view/result";
    }

    //등록
    @PostMapping("enroll")
    public String enrollMusic(@ModelAttribute("music")MusicDTO music, RedirectAttributes redirectAttributes) throws MusicEnrollException{

       if("".equals(music.getSinger())||"".equals(music.getTitle())) {
           throw new MusicEnrollException("가수와 음악이름은 꼭 입력하세요!!!");
       }

       redirectAttributes.addFlashAttribute("flashMessage",music.getSinger()+"은 이미 있지롱");

        return "redirect:/";
    }

    @ExceptionHandler(MusicEnrollException.class)
    public String musicEnrollException(MusicEnrollException exception, Model model) {

        model.addAttribute("exception", exception);

        return "AJM/error/exception";

    }

}
