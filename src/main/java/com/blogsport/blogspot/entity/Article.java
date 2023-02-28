package com.blogsport.blogspot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private String content;

    public Article() {

    }
    public Article(String title, String description, String content) {
        this.title = title;
        this.content = content;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Article[id%d, title='%s', description='%s', content='%s']",
                id, title, description, content);
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
