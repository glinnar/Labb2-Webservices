package com.iths.labb2.controllers;

import com.google.gson.Gson;
import com.iths.labb2.dtos.SnakeDto;
import com.iths.labb2.dtos.SnakeType;
import com.iths.labb2.services.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SnakeController.class)
class SnakeControllerTest {

    @MockBean
    Service service;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void listALLSnakesInDatabase() throws Exception {
        when(service.getAllSnakes()).thenReturn(List.of(new SnakeDto(1, "Sir Hizz", "Viper", 20.00, "Male")));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/snakes")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);

    }

    @Test
    void getOneSnakeWithSpecificId() throws Exception {
        SnakeDto snakeDto = new SnakeDto(1, "Sir Hizz", "Viper", 20.00, "Male");
        when(service.getOne(1)).thenReturn(Optional.of(snakeDto));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/snakes/{id}", snakeDto.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);

    }

    @Test
    void getOneSnakeWithInvalidIdshouldReturn404() throws Exception {
        SnakeDto snakeDto = new SnakeDto(1, "Sir Hizz", "Viper", 20.00, "Male");
        when(service.getOne(snakeDto.getId())).thenReturn(null);

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/snakes/{id}", 2)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(404);
    }


    @Test
    void createASnake() throws Exception {
        SnakeDto snakeDto = new SnakeDto(1, "Sir Hizz", "Viper", 20.00, "Male");
        Gson gson = new Gson();
        when(service.createSnake(snakeDto)).thenReturn(snakeDto);

        var result = mockMvc.perform(MockMvcRequestBuilders.post("/snakes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(snakeDto))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(201);


    }

    @Test
    void deleteASnakeWithSpecificId() throws Exception {
        SnakeDto snakeDto = new SnakeDto(1, "Sir Hizz", "Viper", 20.00, "Male");
        when(service.getOne(snakeDto.getId())).thenReturn(Optional.of(snakeDto));
        doNothing().when(service).deleteSnake(snakeDto.getId());

        var result = mockMvc.perform(MockMvcRequestBuilders.delete("/snakes/{id}", snakeDto.getId()))
                .andExpect(status().isOk())
                .andReturn();


        assertThat(result.getResponse().getStatus()).isEqualTo(200);

    }

    @Test
    void replaceASpecificSnakeById() throws Exception {
        SnakeDto snakeDto = new SnakeDto(1, "Sir Hizz", "Viper", 20.00, "Male");
        SnakeDto newsnakeDto = new SnakeDto(1, "Nagini", "Cobra", 40.00, "Female");
        Gson gson = new Gson();
        when(service.replaceSnake(snakeDto.getId(), snakeDto)).thenReturn(newsnakeDto);
        var result = mockMvc.perform(MockMvcRequestBuilders.put("/snakes/{id}", snakeDto.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(snakeDto)))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);

    }

    @Test
    void updateASnakesType() throws Exception {
        SnakeDto snakeDto = new SnakeDto(1, "Sir Hizz", "Viper", 20.00, "Male");
        SnakeType snakeType = new SnakeType();
        Gson gson = new Gson();
        when(service.updateSnake(snakeDto.getId(), snakeType)).thenReturn(snakeDto);

        var result = mockMvc.perform(MockMvcRequestBuilders.patch("/snakes/{id}", snakeDto.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(snakeDto)))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    void searchSnakeByGenderShouldReturnAllSnakesWithSpecificGender() throws Exception {
        SnakeDto snakeDto = new SnakeDto(1, "Sir Hizz", "Viper", 20.00, "Male");
        when(service.searchByGender(snakeDto.getGender())).thenReturn(List.of(new SnakeDto(1, "Sir Hizz", "Viper", 20.00, "Male")));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/snakes/search/?gender=Male")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);


    }
}