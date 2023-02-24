package com.blogsport.blogspot.repository;


import com.blogsport.blogspot.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByTitle(String title);

    List<Post> findAll();
    Post findById(long id);
}
