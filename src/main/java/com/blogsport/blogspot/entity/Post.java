package com.blogsport.blogspot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private String content;

    public Post() {

    }
    public Post(String title, String description, String content) {
        this.title = title;
        this.content = content;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Post[id%d, title='%s', description='%s', content='%s']",
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
}
