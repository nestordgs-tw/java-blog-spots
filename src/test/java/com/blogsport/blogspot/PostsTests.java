package com.blogsport.blogspot;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
public class PostsTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloResponseString() throws Exception {
        this.mockMvc.perform(get("/posts/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.equalTo("Hello Tester")));
    }
}
