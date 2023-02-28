package com.blogsport.blogspot.controllers;

import com.blogsport.blogspot.entity.Article;
import com.blogsport.blogspot.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class ArticleController {

    private final Environment env;
    private final ArticleServiceImpl articleService;

    @Autowired
    public ArticleController(ArticleServiceImpl postService, Environment env) {
        this.articleService = postService;
        this.env = env;
    }

    @GetMapping("/hello")
    public String sayHello() {
        // TODO: ejemplo lectura de properties, se debe importar Enviroment y luego leerlo (BORRAR)
        String path = env.getProperty("test.var");
        System.out.println(path);

        return "Hello Tester";
    }

    @GetMapping("/")
    public List<Article> getPosts() {
        return new ArrayList<>(articleService.findAll());
    }
}
