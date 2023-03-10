package com.blogsport.blogspot.service;

import com.blogsport.blogspot.dto.ArticleDto;
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

    public List<ArticleDto> findAll2() {
        return this.articleRepository.findAll2();
    }

    public boolean insert(Article article){
        return this.articleRepository.insert(article);
    }

    @Override
    public long deleteById(long id) throws Exception {
        Article article = this.articleRepository.findById(id);

        if (article == null) {
            throw new NullPointerException("Article does not exists");
        }

        boolean resultDelete = this.articleRepository.deleteById(id);

        if (resultDelete) {
            return id;
        } else {
            throw new NullPointerException("Something went wrong");
        }
    }


    public long updateById(long id) throws Exception{
        if (this.articleRepository.findById(id) != null) {
            if (this.articleRepository.updateById(id)) {
                return id;
            } else {
                throw new NullPointerException("Something went wrong");
            }
        } else{
            throw new NullPointerException("Article does not exists");
        }
    }

    @Override
    public Article findById(long id) throws Exception {
        return this.articleRepository.findById(id);
    }

    @Override
    public long update(long id, Article articleDto) throws Exception {

        Article toBeUpdate = mapToUpdate(id, articleDto);
        boolean result = this.articleRepository.update(toBeUpdate);

        if(result) return id;

        throw new NullPointerException("Article does not update");
    }

    private Article mapToUpdate(long id, Article articleDto) throws Exception {

        Article oldArticle = this.articleRepository.findById(id);
        articleDto.setId(oldArticle.getId());

        return articleDto;
    }
}
