package com.iths.labb2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

   private SnakeRepository snakeRepository;

   @Autowired
    public Controller(SnakeRepository snakeRepository) {
        this.snakeRepository = snakeRepository;
    }

    @GetMapping("/hello")
    public List<Snake> sayHello(){

        return snakeRepository.findAll();

    }

    @GetMapping("/Tjena")
    public Optional<Snake> sayyoo(){
        snakeRepository.save(new Snake("Olle","Kobra", '3',"Male"));

        return snakeRepository.findById(2);
    }


}
