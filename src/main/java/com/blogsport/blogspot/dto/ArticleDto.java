package com.blogsport.blogspot.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ArticleDto {

    private Long id;
    private String title;
    private String description;
    private String content;
}
