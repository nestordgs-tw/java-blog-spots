package com.blogsport.blogspot.controller;

import com.blogsport.blogspot.controllers.ArticleController;
import com.blogsport.blogspot.entity.Article;
import com.blogsport.blogspot.service.ArticleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
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

    @Disabled()
    @Test
    @DisplayName("Update Path method OK")
    void updatePathController() throws Exception {
        long id = 1;
        long mockResult = 1;

        when(articleService.updateById(id)).thenReturn(id);

        assertThat(mockResult).isEqualTo(articleController.updateByIdPath(id));
    }

    @Disabled()
    @Test
    @DisplayName("Update Path method NOT OK")
    void updatePathControllerNOTOk() throws Exception {
        long id = 1;
        String exceptionMessageExpected = "Article does not exists";

        when(articleService.updateById(id)).thenThrow(new Exception(exceptionMessageExpected));

        assertThat(exceptionMessageExpected).isEqualTo(articleController.updateByIdPath(id));
    }

    @Disabled()
    @Test
    @DisplayName("Update Body method OK")
    void updateBodyController() throws Exception {
        Article articleMock = new Article("Title one", "Testing description 1", "Testing Content");
        String mockResult = "1";

        when(articleService.updateById(articleMock.getId())).thenReturn(articleMock.getId());

        assertThat(mockResult).isEqualTo(articleController.updateById(articleMock));
    }

    @Disabled
    @Test
    @DisplayName("Update Body method NOT OK")
    void updateBodyControllerNOTOk() throws Exception {
        Article articleMock = new Article("Title one", "Testing description 1", "Testing Content");
        String exceptionMessageExpected = "Article does not exists";

        when(articleService.updateById(articleMock.getId())).thenThrow(new Exception(exceptionMessageExpected));
        
        assertThat(exceptionMessageExpected).isEqualTo(articleController.updateById(articleMock));
    }

    @Test
    void existingArticleById_ShouldReturn_ArticleObject() throws Exception {
        long mockedId = 1L;
        Article expectedResponse = new Article("Title one", "Testing description 1", "Testing Content");
        expectedResponse.setId(1L);

        when(articleService.findById(mockedId)).thenReturn(expectedResponse);
        ResponseEntity<Article> result = articleController.findById(mockedId);

        assertThat(Objects.requireNonNull(result.getBody()).getId()).isNotNull();
    }

        @Test
        void nonExistingArticleById_ShouldThrow_Exception() throws Exception {

        long mockedId = 1L;

        when(articleService.findById(mockedId)).thenThrow(new Exception("Article not found"));

        assertThrows(Exception.class, () -> {
            articleController.findById(1L);
        });
    }

}
