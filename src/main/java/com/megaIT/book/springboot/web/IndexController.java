package com.megaIT.book.springboot.web;


import com.megaIT.book.springboot.config.auth.LoginUser;
import com.megaIT.book.springboot.config.auth.dto.SessionUser;
import com.megaIT.book.springboot.service.PostsService;
import com.megaIT.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){ //Loginuser가 스프링에 등록시킴(메소드 인자로 세션값을 바로 받을 수 있도록 하기위해)
        model.addAttribute("posts", postsService.findAllDesc());
        if(user != null){
            model.addAttribute("userName1",user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts",dto);
        return "posts-update";
    }

}
