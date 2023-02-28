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

class ArticleServiceImplTest {
//    @InjectMocks
    ArticleServiceImpl articleService;

//    @Mock
    ArticleRepositoryImpl articleRepository;

    @BeforeEach
    public void setUp() {
//        MockitoAnnotations.openMocks(this);
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

        Mockito.when(articleRepository.findAll()).thenReturn(mockedList);

        List<Article> result = articleService.findAll();

        Assertions.assertEquals(3, result.size());
    }
}