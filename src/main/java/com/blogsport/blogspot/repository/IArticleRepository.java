package com.blogsport.blogspot.repository;


import com.blogsport.blogspot.entity.Article;

import java.util.List;

public interface IArticleRepository {

    List<Article> findByTitle(String title);

    Iterable<Article> findAll();

    Article findById(long id);

}
