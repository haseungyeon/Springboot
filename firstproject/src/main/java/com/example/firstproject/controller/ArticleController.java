package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    @GetMapping("/news")
            public String articleContents(Model model){
        String contents = (String)model.getAttribute("contents");
        String anker = (String)model.getAttribute("name");
        model.addAttribute("article", contents);
        model.addAttribute("anker", anker);
        return "article/news";
    }
}
