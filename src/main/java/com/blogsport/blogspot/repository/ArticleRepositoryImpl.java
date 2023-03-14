package com.blogsport.blogspot.repository;

import com.blogsport.blogspot.dto.ArticleDto;
import com.blogsport.blogspot.entity.Article;
import com.blogsport.blogspot.mapper.ArticleRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ArticleRepositoryImpl implements IArticleRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String SQL_INSERT_ARTICLE = "insert into article(title, description, content) values(?,?,?)";
    private final String SQL_UPDATE_ARTICLE = "UPDATE article SET TITLE = ?, DESCRIPTION = ?, CONTENT = ? WHERE ID = ?";
    private final String SQL_UPDATE_PERSON = "UPDATE ARTICLE SET ID = ? WHERE ID = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public List<ArticleDto> findAll2() {

        final String table = "article";
        String query = String.format("SELECT id, title, description, content FROM %s", table);

        return jdbcTemplate.query(
            query,
            new ArticleRowMapper());
    }

    @Override
    public Article findById(long id) throws Exception {
        String query  = String.format("SELECT * FROM article WHERE id = %s", id);
        try {
            return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Article.class));
        } catch (Exception e) {
            logger.error("Article not found");
            return null;
        }
    }

    @Override
    public boolean deleteById(long id) {
        String query = "DELETE FROM article WHERE id = ?";
        try {
            return jdbcTemplate.update(query, id) == 1;
        } catch (Exception e) {
            logger.error("Something went wrong");
            return false;
        }
    }

    public boolean insert(Article article) {
        return jdbcTemplate.update(SQL_INSERT_ARTICLE, article.getTitle(), article.getDescription(), article.getContent()) > 0;
    }

    public boolean updateById(long id) {
        try {
            return jdbcTemplate.update(SQL_UPDATE_PERSON, id) == 1;
        } catch (Exception e) {
            logger.error("Something went wrong");
            return false;
        }
    }

    @Override
    public boolean update(Article article) {
        return jdbcTemplate.update(
                SQL_UPDATE_ARTICLE,
                article.getTitle(),
                article.getDescription(),
                article.getContent(),
                article.getId()) > 0;
    }
}
