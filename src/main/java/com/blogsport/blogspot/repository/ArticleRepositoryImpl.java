package com.blogsport.blogspot.repository;

import com.blogsport.blogspot.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ArticleRepositoryImpl implements IArticleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Article> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Article> findAll() {
        List<Article> myArticles = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT id, title, description content FROM {TABLE_NAME}".format(TABLENAME));
        System.out.println(rows);

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
}
