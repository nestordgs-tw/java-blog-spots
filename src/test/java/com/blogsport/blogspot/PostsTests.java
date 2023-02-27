package com.blogsport.blogspot;

import com.blogsport.blogspot.controllers.PostController;
import com.blogsport.blogspot.entity.Post;
import com.blogsport.blogspot.services.PostServiceImpl;
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
public class PostsTests {

    @InjectMocks
    PostController postController;

    @Mock
    PostServiceImpl postService;

    @Test
    @DisplayName("Testing sayHelloController")
    void sayHelloController() {
        String result = postController.sayHello();

        assertThat(result).isEqualTo("Hello Tester");
    }


    @Test
    @DisplayName("Testing getPostsController")
    void getPostsController() {
        List<Post> mockedList = new ArrayList<>();

        mockedList.add(new Post("Title one", "Testing description 1", "Testing Content"));
        mockedList.add(new Post("Title two", "Testing description 2", "Testing Content"));
        mockedList.add(new Post("Title three", "Testing description 3", "Testing Content"));


        when(postService.findAll()).thenReturn(mockedList);
        List<Post> result = postController.getPosts();

        assertThat(result.size()).isEqualTo(3);
    }


}
