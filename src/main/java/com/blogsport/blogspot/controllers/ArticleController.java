package com.blogsport.blogspot.controllers;

import com.blogsport.blogspot.entity.Article;
import com.blogsport.blogspot.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class ArticleController {


    private final ArticleServiceImpl articleService;

    @Autowired
    public ArticleController(ArticleServiceImpl postService) {
        this.articleService = postService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Tester";
    }

    @GetMapping("/")
    public List<Article> getPosts() {
        return new ArrayList<>(articleService.findAll());
    }
}
