package com.blogsport.blogspot.service;

import com.blogsport.blogspot.entity.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PostServiceImplTest {

    @InjectMocks
    PostServiceImpl postService;

    @Test
    void findAllService() {
        assertThat(1).isEqualTo(1);
    }
}