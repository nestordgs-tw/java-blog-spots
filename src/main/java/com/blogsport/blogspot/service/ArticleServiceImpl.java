package com.blogsport.blogspot.service;

import com.blogsport.blogspot.entity.Article;
import com.blogsport.blogspot.repository.ArticleRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    private final ArticleRepositoryImpl articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepositoryImpl articleRepository) {
        this.articleRepository = articleRepository;
    }


    public List<Article> findAll() {
        return this.articleRepository.findAll();
    }

    @Override
    public List<Article> findByTitle(String title) {
        return null;
    }

    @Override
    public long deleteById(long id) throws Exception {

        Article article = this.articleRepository.findById(id);

        if (article == null) {
            throw new Exception("Article does not exists");
        }

        boolean resultDelete = this.articleRepository.deleteById(id);

        if (resultDelete) {
            return id;
        } else {
            throw new Exception("Something went wrong");
        }
    }
}
