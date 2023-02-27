package com.blogsport.blogspot.services;

import com.blogsport.blogspot.beans.PostRepositoryImpl;
import com.blogsport.blogspot.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class PostService {

    @Autowired
    public PostService(PostRepositoryImpl postRepositoryIm) {
    }


    public List<Post> findAll() {
        List<Post> myList = new ArrayList<>();


        myList.add(new Post("Title one", "Testing description 1", "Testing Content"));
        myList.add(new Post("Title two", "Testing description 2", "Testing Content"));
        myList.add(new Post("Title three", "Testing description 3", "Testing Waka"));

        return myList;
    }
}
