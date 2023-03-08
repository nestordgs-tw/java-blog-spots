package com.blogsport.blogspot.repository;


import com.blogsport.blogspot.entity.Article;

import java.util.List;

public interface IArticleRepository {

    List<Article> findByTitle(String title);

    Iterable<Article> findAll();

    Article findById(long id) throws Exception;

    boolean insert(Article article);
    
    boolean deleteById(long id);

    boolean updateById(long id);

    Article update(long id, Article article);

}
