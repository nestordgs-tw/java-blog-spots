package com.blogsport.blogspot.controller;

import com.blogsport.blogspot.controllers.ArticleController;
import com.blogsport.blogspot.entity.Article;
import com.blogsport.blogspot.service.ArticleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;

@ExtendWith(MockitoExtension.class)
public class ArticleControllerTest {

    @InjectMocks
    ArticleController articleController;

    @Mock
    ArticleServiceImpl articleService;

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


        when(articleService.findAll()).thenReturn(mockedList);
        List<Article> result = articleController.getPosts();

        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void shouldReturnOkStatusWhenInsertArticleIsSuccess() {

        Article articleMock = new Article("Title one", "Testing description 1", "Testing Content");

        when(articleService.insert(articleMock)).thenReturn(true);

        ResponseEntity<Boolean> expectedResponse =  new ResponseEntity<>(true, CREATED);
        ResponseEntity<Boolean> result = articleController.insert(articleMock);

        Assertions.assertEquals(expectedResponse, result);
    }

    @Test
    @DisplayName("Delete method OK")
    void deletePostController() throws Exception {
        long id = 1;
        String mockResult = "1";

        when(articleService.deleteById(id)).thenReturn(id);

        String result = articleController.deleteById(id);

        assertThat(result).isEqualTo(mockResult);
    }

    @Test
    @DisplayName("Delete method NOT OK")
    void deletePostControllerNOTOk() throws Exception {
        long id = 1;
        String exceptionMessageExpected = "Article does not exists";

        when(articleService.deleteById(id)).thenThrow(new Exception(exceptionMessageExpected));

        String result = articleController.deleteById(id);

        assertThat(exceptionMessageExpected).isEqualTo(result);
    }
}
