package com.blogsport.blogspot.services;

import com.blogsport.blogspot.entity.Post;
import com.blogsport.blogspot.repository.PostRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class PostServiceImpl implements IPostService {

    private final PostRepositoryImpl postRepositoryIm;

    @Autowired
    public PostServiceImpl(PostRepositoryImpl postRepositoryIm) {
        this.postRepositoryIm = postRepositoryIm;
    }


    public List<Post> findAll() {
        List<Post> result = this.postRepositoryIm.findAll();

        System.out.println(result);

        return result;
    }

    @Override
    public List<Post> findByTitle(String title) {
        return null;
    }
}
