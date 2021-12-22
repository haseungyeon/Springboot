package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //로깅을 위한 어노테이션
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
        //System.out.println(form.toString()); 실제 서버에서는 기록이 남지 않고 서버에 악영향을 미치므로 사용하지 않음. 롬복의 로깅 기능으로 대체함
        log.info(form.toString());

        //2. db가 인식할 수 있도록 dto를 entity로 변환
        Article article = form.toEntity();
        log.info(article.toString());
        //System.out.println(article.toString());

        //3. entity로 변환된 객체를 db에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        return "articles/create";
    }
}
