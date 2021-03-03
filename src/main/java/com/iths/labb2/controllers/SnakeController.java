package com.iths.labb2.controllers;

import com.iths.labb2.dtos.SnakeDto;
import com.iths.labb2.dtos.SnakeType;
import com.iths.labb2.services.SnakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SnakeController {

    private SnakeService snakeService;

    @Autowired
    public SnakeController(SnakeService snakeService) {
        this.snakeService = snakeService;
    }

    @GetMapping("/snakes")
    public List<SnakeDto> listSnakes() {
        return snakeService.getAllSnakes();
    }


    @GetMapping("/snake/{id}")
    public SnakeDto getOne(@PathVariable Integer id) {
        return snakeService.getOne(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found."));

    }


    @PostMapping("/snakes")
    @ResponseStatus(HttpStatus.CREATED)
    public SnakeDto create(@RequestBody SnakeDto snake) {
        return snakeService.createSnake(snake);

    }

    @DeleteMapping("/snakes/{id}")
    public void delete(@PathVariable Integer id) {
        snakeService.deleteSnake(id);

    }

    @PutMapping("/snakes/{id}")
    public SnakeDto replace(@RequestBody SnakeDto snakeDto, @PathVariable Integer id) {
        return snakeService.replaceSnake(id, snakeDto);

    }

    @PatchMapping("/snakes/{id}")
    public SnakeDto update(@RequestBody SnakeType snakeType, @PathVariable Integer id) {
        return snakeService.updateSnake(id, snakeType);

    }


}
