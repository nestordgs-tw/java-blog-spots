package com.blogsport.blogspot.repository;

import com.blogsport.blogspot.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ArticleRepositoryImpl implements IArticleRepository {

    private final String SQL_INSERT_PERSON = "insert into article(title, description, content) values(?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    SimpleJdbcInsert simpleJdbcInsert;

    @Override
    public List<Article> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        String query = String.format("SELECT id, title, description, content FROM %s", "article");
        List<Article> myArticles = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row: rows) {
            Article article = new Article();
            article.setId((Long) row.get("id"));
            article.setTitle((String) row.get("title"));
            article.setContent((String) row.get("content"));
            article.setDescription((String) row.get("description"));

            myArticles.add(article);
        }

        return myArticles;
    }

    @Override
    public Article findById(long id) {
        return null;
    }

    public boolean insert(Article article) {
        return jdbcTemplate.update(SQL_INSERT_PERSON, article.getTitle(), article.getDescription(), article.getContent()) > 0;
    }

}
