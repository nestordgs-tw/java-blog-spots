package com.blogsport.blogspot.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.assertj.core.api.Assertions.assertThat;

class PostServiceImplTest {

    @InjectMocks
    PostServiceImpl postService;

    @Test
    void findAllService() {
        assertThat(1).isEqualTo(1);
    }
}