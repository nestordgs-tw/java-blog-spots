package com.blogsport.blogspot.controllers;

import com.blogsport.blogspot.dto.ArticleDto;
import com.blogsport.blogspot.entity.Article;
import com.blogsport.blogspot.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDto>> findAll() {

        List<ArticleDto> response = articleService.findAll2();

        if(null != response){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/article/{id}")
        public ResponseEntity<Article> findById(@PathVariable long id) throws Exception {

            Article article = this.articleService.findById(id);

            if(article == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(article, HttpStatus.OK);
    }


    @PostMapping("/article")
    public ResponseEntity<Boolean> insert(@RequestBody Article article){

        boolean createdArticle =  articleService.insert(article);

        return new ResponseEntity<>(createdArticle, HttpStatus.CREATED);
    }

    @DeleteMapping("/article/{id}")
    public String deleteById(@PathVariable("id") long id) {
        try {
            long idDeleted = articleService.deleteById(id);
            return String.format("%s", idDeleted);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping(value= "/article/update/{id}")
    public ResponseEntity<String> updateByIdPath(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(String.format("%s", articleService.updateById(id)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value= "/article/update")
    public ResponseEntity<String> updateById(@RequestBody Article article) {
        try {
            return new ResponseEntity<>(String.format("%s", articleService.updateById(article.getId())), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/article/{id}")
    public ResponseEntity<String> update(@PathVariable long id , @RequestBody Article requestBody) throws Exception {

        long response = articleService.update(id, requestBody);

        return new ResponseEntity<>(String.format("Articulo actualizado ID: %s", response), HttpStatus.OK);

    }
}
