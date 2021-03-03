package com.iths.labb2.controllers;


import com.iths.labb2.services.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(SnakeController.class)
@Import({TestService.class})
public class MvcTest {

    @Autowired
    Service service;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void callingAllSnakesShouldReturnAllSnakesInDatabase() throws Exception {
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/snakes")
                .accept(MediaType.APPLICATION_JSON)).andReturn();


        assertThat(result.getResponse().getStatus()).isEqualTo(200);

    }

}
