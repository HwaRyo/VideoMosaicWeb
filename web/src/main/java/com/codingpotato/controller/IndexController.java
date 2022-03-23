package com.codingpotato.controller;

import com.codingpotato.config.auth.LoginUser;
import com.codingpotato.config.auth.SecurityConfig;
import com.codingpotato.config.auth.dto.SessionUser;
import com.codingpotato.dto.PostsResponseDto;
import com.codingpotato.service.posts.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String login(){
        return "index";
    }



}