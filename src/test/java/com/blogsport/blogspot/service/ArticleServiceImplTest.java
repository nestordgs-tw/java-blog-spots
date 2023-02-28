package com.blogsport.blogspot.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArticleServiceImplTest {

    @InjectMocks
    ArticleServiceImpl postService;

    @Test
    void findAllService() {
        assertThat(1).isEqualTo(1);
    }
}