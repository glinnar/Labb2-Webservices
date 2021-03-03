package com.iths.labb2.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SnakeControllerTest {

    @Test
    void listALLSnakesInDatabase() {
    }

    @Test
    void getOneSnakeWithSpecificId() {
        SnakeController snakeController = new SnakeController(new TestService());
        var snake = snakeController.getOne(1);
        assertThat(snake.getId()).isEqualTo(1);
        assertThat(snake.getName()).isEqualTo("Test");
        assertThat(snake.getType()).isEqualTo("Test");
        assertThat(snake.getWeight()).isEqualTo(20.12);
        assertThat(snake.getGender()).isEqualTo("Male");

    }

    @Test
    void testThatInvalidIdThrowsExeption() {
        SnakeController snakeController = new SnakeController(new TestService());

        var exception = assertThrows(ResponseStatusException.class, () -> snakeController.getOne(2));
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);


    }

    @Test
    void createASnake() {
    }

    @Test
    void deleteASnakeWithSpecificId() {
    }

    @Test
    void replaceASpecificSnakeById() {
    }

    @Test
    void updateASnake() {
    }
}