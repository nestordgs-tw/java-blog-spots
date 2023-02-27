package com.blogsport.blogspot.controllers;

import com.blogsport.blogspot.entity.Post;
import com.blogsport.blogspot.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class Posts {

    PostRepository postRepository;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Tester";
    }

    @GetMapping("/")
    public List<Post> getPosts() {
        for (Post post: postRepository.findAll()) {
            System.out.println(post.toString());
        }

        return new ArrayList<Post>(postRepository.findAll());
    }
}
