package com.blogsport.blogspot.controller;

import com.blogsport.blogspot.controllers.ArticleController;
import com.blogsport.blogspot.entity.Article;
import com.blogsport.blogspot.service.ArticleServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostsControllerTest {

    @InjectMocks
    ArticleController articleController;

    @Mock
    ArticleServiceImpl postService;

    @Test
    @DisplayName("Testing sayHelloController")
    void sayHelloController() {
        String result = articleController.sayHello();

        assertThat(result).isEqualTo("Hello Tester");
    }


    @Test
    @DisplayName("Testing getPostsController")
    void getPostsController() {
        List<Article> mockedList = new ArrayList<>();

        mockedList.add(new Article("Title one", "Testing description 1", "Testing Content"));
        mockedList.add(new Article("Title two", "Testing description 2", "Testing Content"));
        mockedList.add(new Article("Title three", "Testing description 3", "Testing Content"));


        when(postService.findAll()).thenReturn(mockedList);
        List<Article> result = articleController.getPosts();

        assertThat(result.size()).isEqualTo(3);
    }


}
