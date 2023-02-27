package com.blogsport.blogspot.services;

import com.blogsport.blogspot.entity.Post;

import java.util.List;

public interface IPostService {

    List<Post> findAll();

    List<Post> findByTitle(String title);
}
