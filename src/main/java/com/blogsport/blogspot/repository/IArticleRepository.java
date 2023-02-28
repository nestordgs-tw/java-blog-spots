package com.blogsport.blogspot.repository;


import com.blogsport.blogspot.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IArticleRepository extends CrudRepository<Article, Long> {

    List<Article> findByTitle(String title);

    List<Article> findAll();
    Article findById(long id);

}
