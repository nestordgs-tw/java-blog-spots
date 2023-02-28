package com.blogsport.blogspot.service;

import com.blogsport.blogspot.entity.Article;
import com.blogsport.blogspot.repository.ArticleRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class ArticleServiceImplTest {

    @InjectMocks
    ArticleServiceImpl articleService;

    @Mock
    ArticleRepositoryImpl articleRepository;

    @Test
    void findAllService() {
        List<Article> mockedList = new ArrayList<>();

        mockedList.add(new Article("Title one", "Testing description 1", "Testing Content"));
        mockedList.add(new Article("Title two", "Testing description 2", "Testing Content"));
        mockedList.add(new Article("Title three", "Testing description 3", "Testing Content"));

        when(articleRepository.findAll()).thenReturn(mockedList);

        List<Article> result = articleService.findAll();

        assertThat(result.size()).isEqualTo(3);
//        assertThat(1).isEqualTo(1);
    }
}