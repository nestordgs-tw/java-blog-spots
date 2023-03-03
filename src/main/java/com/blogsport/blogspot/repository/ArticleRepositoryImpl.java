package com.blogsport.blogspot.repository;

import com.blogsport.blogspot.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
        String query  = String.format("SELECT * FROM article WHERE id = %s", id);
        try {
            return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Article.class));
        } catch (Exception e) {
            System.out.println("User not found");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteById(long id) {
        String query = "DELETE FROM article WHERE id = ?";
        try {
            return jdbcTemplate.update(query, id) == 1;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean insert(Article article) {
        return jdbcTemplate.update(SQL_INSERT_PERSON, article.getTitle(), article.getDescription(), article.getContent()) > 0;
    }

}
