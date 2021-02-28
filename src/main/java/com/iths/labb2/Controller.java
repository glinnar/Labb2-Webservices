package com.iths.labb2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class Controller {

    private SnakeRepository snakeRepository;

    @Autowired
    public Controller(SnakeRepository snakeRepository) {
        this.snakeRepository = snakeRepository;
    }

    @GetMapping("/Snakes")
    public List<Snake> listSnakes() {
        return snakeRepository.findAll();
    }

    @GetMapping("/snake/{id}")
    public Snake getOne(@PathVariable Integer id) {
        return snakeRepository.findById(id)
                .orElseThrow(()->  new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Id " + id + " not found."));

    }

   /* @GetMapping("/addSnakes")
    public Optional<Snake> addSnake() {
        snakeRepository.save(new Snake("Olle", "Kobra", '3', "Male"));

        return snakeRepository.findById(2);
    }*/


}
