package com.blogsport.blogspot.controllers;

import com.blogsport.blogspot.entity.Post;
import com.blogsport.blogspot.services.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostServiceImpl postService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Tester";
    }

    @GetMapping("/")
    public List<Post> getPosts() {
        return new ArrayList<Post>(postService.findAll());
    }
}
