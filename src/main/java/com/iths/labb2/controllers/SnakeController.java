package com.iths.labb2.controllers;

import com.iths.labb2.dtos.SnakeDto;
import com.iths.labb2.dtos.SnakeType;
import com.iths.labb2.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


public class SnakeController {

    private Service service;

    @Autowired
    public SnakeController(Service service) {
        this.service = service;
    }

    @GetMapping("/snakes")
    public List<SnakeDto> listSnakes() {
        return service.getAllSnakes();
    }


    @GetMapping("/snakes/{id}")
    public SnakeDto getOne(@PathVariable Integer id) {
        return service.getOne(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found."));

    }


    @PostMapping("/snakes")
    @ResponseStatus(HttpStatus.CREATED)
    public SnakeDto create(@RequestBody SnakeDto snake) {
        return service.createSnake(snake);

    }

    @DeleteMapping("/snakes/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteSnake(id);

    }

    @PutMapping("/snakes/{id}")
    public SnakeDto replace(@RequestBody SnakeDto snakeDto, @PathVariable Integer id) {
        return service.replaceSnake(id, snakeDto);

    }

    @PatchMapping("/snakes/{id}")
    public SnakeDto update(@RequestBody SnakeType snakeType, @PathVariable Integer id) {
        return service.updateSnake(id, snakeType);

    }


}
