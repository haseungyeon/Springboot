package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired  //스프링부트가 자동생성한 객체에 연결해주는 역할
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        //1. form 태그로부터 입력받은 정보 출력
        System.out.println(form.toString());

        //2. db가 인식할 수 있도록 dto를 entity로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());

        //3. entity로 변환된 객체를 db에 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return "articles/create";
    }
}
