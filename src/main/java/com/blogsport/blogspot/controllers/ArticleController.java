package com.blogsport.blogspot.controllers;

import com.blogsport.blogspot.entity.Article;
import com.blogsport.blogspot.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") long id) throws Exception {
        try {
            return String.format("%s", articleService.deleteById(id));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
