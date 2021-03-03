package com.iths.labb2.controllers;

import com.iths.labb2.dtos.SnakeDto;
import com.iths.labb2.dtos.SnakeType;
import com.iths.labb2.services.Service;

import java.util.List;
import java.util.Optional;

public class TestService implements Service {
    @Override
    public List<SnakeDto> getAllSnakes() {
        return List.of(new SnakeDto(1,"Test","Test",20.12,"Male")
                ,new SnakeDto(2,"Test1","Test1",20.12,"Female"));
    }

    @Override
    public Optional<SnakeDto> getOne(Integer id) {
        if(id ==1)
            return Optional.of(new SnakeDto(1,"Test","Test",20.12,"Male"));

        return Optional.empty();
    }

    @Override
    public SnakeDto createSnake(SnakeDto snake) {
        return null;
    }

    @Override
    public void deleteSnake(Integer id) {

    }

    @Override
    public SnakeDto replaceSnake(Integer id, SnakeDto snakeDto) {
        return null;
    }

    @Override
    public SnakeDto updateSnake(Integer id, SnakeType snakeType) {
        return null;
    }
}
