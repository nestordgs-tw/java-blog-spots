package com.blogsport.blogspot.service;

import com.blogsport.blogspot.entity.Article;
import com.blogsport.blogspot.repository.ArticleRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    private final ArticleRepositoryImpl postRepositoryIm;

    @Autowired
    public ArticleServiceImpl(ArticleRepositoryImpl postRepositoryIm) {
        this.postRepositoryIm = postRepositoryIm;
    }


    public List<Article> findAll() {
        return this.postRepositoryIm.findAll();
    }

    @Override
    public List<Article> findByTitle(String title) {
        return null;
    }
}
