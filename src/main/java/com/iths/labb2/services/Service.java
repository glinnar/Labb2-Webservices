package com.iths.labb2.services;

import com.iths.labb2.dtos.SnakeDto;
import com.iths.labb2.dtos.SnakeType;

import java.util.List;
import java.util.Optional;

public interface Service {
    List<SnakeDto> getAllSnakes();

    Optional<SnakeDto> getOne(Integer id);

    SnakeDto createSnake(SnakeDto snake);

    void deleteSnake(Integer id);

    SnakeDto replaceSnake(Integer id, SnakeDto snakeDto);

    SnakeDto updateSnake(Integer id, SnakeType snakeType);
}
