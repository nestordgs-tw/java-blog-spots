package com.blogsport.blogspot.service;

import com.blogsport.blogspot.dto.ArticleDto;
import com.blogsport.blogspot.entity.Article;

import java.util.List;

public interface IArticleService {

    List<Article> findAll();

    List<ArticleDto> findAll2();

    long deleteById(long id) throws Exception;

    long updateById(long id) throws Exception;

    Article findById(long id) throws Exception;

    long update(long id, Article article) throws Exception;
}
