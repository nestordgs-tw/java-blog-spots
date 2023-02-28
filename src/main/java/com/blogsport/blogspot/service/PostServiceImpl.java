package com.blogsport.blogspot.service;

import com.blogsport.blogspot.entity.Post;
import com.blogsport.blogspot.repository.PostRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    private final PostRepositoryImpl postRepositoryIm;

    @Autowired
    public PostServiceImpl(PostRepositoryImpl postRepositoryIm) {
        this.postRepositoryIm = postRepositoryIm;
    }


    public List<Post> findAll() {
        List<Post> result = this.postRepositoryIm.findAll();

        return result;
    }

    @Override
    public List<Post> findByTitle(String title) {
        return null;
    }
}
