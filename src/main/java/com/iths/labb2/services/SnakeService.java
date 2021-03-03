package com.iths.labb2.services;

import com.iths.labb2.dtos.SnakeDto;
import com.iths.labb2.mappers.SnakeMapper;
import com.iths.labb2.repositories.SnakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnakeService {
    private final SnakeMapper snakeMapper;
    private SnakeRepository snakeRepository;

    public SnakeService(SnakeRepository snakeRepository,SnakeMapper snakeMapper) {
        this.snakeRepository = snakeRepository;
        this.snakeMapper = snakeMapper;
    }

    public List<SnakeDto> getAllSnakes() {
        return snakeMapper.mapp(snakeRepository.findAll());
    }

    public Optional<SnakeDto> getOne(Integer id) {
        return snakeMapper.mapp(snakeRepository.findById(id));
    }

    public SnakeDto createSnake(SnakeDto snake) {
        if (snake.getName().isEmpty())
            throw new RuntimeException();

        return snakeMapper.mapp(snakeRepository.save(snakeMapper.mapp(snake)));
    }

}
