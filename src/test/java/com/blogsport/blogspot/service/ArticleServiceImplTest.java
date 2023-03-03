package com.blogsport.blogspot.service;

import com.blogsport.blogspot.entity.Article;
import com.blogsport.blogspot.repository.ArticleRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class ArticleServiceImplTest {

    ArticleServiceImpl articleService;
    ArticleRepositoryImpl articleRepository;

    @BeforeEach
    public void setUp() {
        articleRepository = Mockito.mock(ArticleRepositoryImpl.class);
        articleService = new ArticleServiceImpl(articleRepository);
    }

    @Test
    @DisplayName("Testing find All method")
    void findAllService() {
        List<Article> mockedList = new ArrayList<>();

        mockedList.add(new Article("Title one", "Testing description 1", "Testing Content"));
        mockedList.add(new Article("Title two", "Testing description 2", "Testing Content"));
        mockedList.add(new Article("Title three", "Testing description 3", "Testing Content"));

        when(articleRepository.findAll()).thenReturn(mockedList);

        List<Article> result = articleService.findAll();

        Assertions.assertEquals(3, result.size());
    }

    @Test
    @DisplayName("Testing Delete item OK")
    void deleteMethodOk() throws Exception {
        long id = 1;
        Article articleMocked = new Article("Tesst", "Description", "Content");
        articleMocked.setId(id);

        when(articleRepository.findById(id)).thenReturn(articleMocked);
        when(articleRepository.deleteById(id)).thenReturn(true);
        long result = articleService.deleteById(id);

        Assertions.assertEquals(result, id);
    }

    @Test
    @DisplayName("Article does not exists")
    void deleteMethodNOTOk() throws Exception {
        long id = 1;
        String exceptionMessageExpected = "Article does not exists";

        when(articleRepository.findById(id)).thenReturn(null);

        Exception exception = assertThrows(Exception.class, () -> articleService.deleteById(id));

        Assertions.assertEquals(exceptionMessageExpected, exception.getMessage());
    }
}