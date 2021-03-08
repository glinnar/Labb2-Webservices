package com.iths.labb2.controllers;

import com.iths.labb2.dtos.SnakeDto;
import com.iths.labb2.dtos.SnakeType;
import com.iths.labb2.services.Service;

import java.util.List;
import java.util.Optional;

public class TestService implements Service {
    @Override
    public List<SnakeDto> getAllSnakes() {
        return List.of(new SnakeDto(1,"Sir Hizz","Viper",20.12,"Male")
                ,new SnakeDto(2,"Kaa","Python",40.12,"Male")
                ,new SnakeDto(3,"Nagini","Cobra",50.22,"Female")
        );
    }

    @Override
    public Optional<SnakeDto> getOne(Integer id) {
        if(id ==1)
            return Optional.of(new SnakeDto(1,"Sir Hizz","Viper",20.12,"Male"));

        return Optional.empty();
    }

    @Override
    public SnakeDto createSnake(SnakeDto snake) {
        return new SnakeDto(4,"Slytherin","Basilisk",500.00,"Male");
    }

    @Override
    public void deleteSnake(Integer id) {
        deleteSnake(3);

    }

    @Override
    public SnakeDto replaceSnake(Integer id, SnakeDto snakeDto) {
        return null;
    }

    @Override
    public SnakeDto updateSnake(Integer id, SnakeType snakeType) {
        return null;
    }

    @Override
    public List<SnakeDto> searchByGender(String gender) {
        return null;
    }
}
