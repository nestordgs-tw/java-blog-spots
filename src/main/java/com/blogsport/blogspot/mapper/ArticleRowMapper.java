package com.blogsport.blogspot.mapper;

import com.blogsport.blogspot.entity.Article;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Article> {

    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {

        Article article = new Article();
        article.setId(rs.getLong("id"));
        article.setTitle(rs.getString("title"));
        article.setDescription(rs.getString("description"));
        article.setContent(rs.getString("content"));

        return article;
    }
}
