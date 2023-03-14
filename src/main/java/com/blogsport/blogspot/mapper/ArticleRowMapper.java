package com.blogsport.blogspot.mapper;

import com.blogsport.blogspot.dto.ArticleDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<ArticleDto> {

    @Override
    public ArticleDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        return ArticleDto.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .content(rs.getString("content"))
                .build();
    }

}
