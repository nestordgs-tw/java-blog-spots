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

    public boolean insert(Article article){
        return this.articleRepository.insert(article);
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


    public long updateById(long id) throws Exception{
        if (this.articleRepository.findById(id) != null) {
            if (this.articleRepository.updateById(id)) {
                return id;
            } else {
                throw new Exception("Something went wrong");
            }
        } else{
            throw new Exception("Article does not exists");
        }
    }
}
