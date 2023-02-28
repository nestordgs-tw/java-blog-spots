package com.blogsport.blogspot.repository;

import com.blogsport.blogspot.entity.Article;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ArticleRepositoryImpl implements IArticleRepository {

    @Override
    public List<Article> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        List<Article> myList = new ArrayList<>();


        myList.add(new Article("Title one", "Testing description 1", "Testing Content"));
        myList.add(new Article("Title two", "Testing description 2", "Testing Content"));
        myList.add(new Article("Title three", "Testing description 3", "Testing Waka"));

        return myList;
    }

    @Override
    public <S extends Article> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Article> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Article> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Article> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Article entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Article> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Article findById(long id) {
        return null;
    }
}
