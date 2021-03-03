package com.iths.labb2.services;

import com.iths.labb2.dtos.SnakeDto;
import com.iths.labb2.dtos.SnakeType;
import com.iths.labb2.entities.Snake;
import com.iths.labb2.mappers.SnakeMapper;
import com.iths.labb2.repositories.SnakeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SnakeService implements com.iths.labb2.services.Service {
    private final SnakeMapper snakeMapper;
    private SnakeRepository snakeRepository;

    public SnakeService(SnakeRepository snakeRepository, SnakeMapper snakeMapper) {
        this.snakeRepository = snakeRepository;
        this.snakeMapper = snakeMapper;
    }

    @Override
    public List<SnakeDto> getAllSnakes() {
        return snakeMapper.mapp(snakeRepository.findAll());
    }

    @Override
    public Optional<SnakeDto> getOne(Integer id) {
        return snakeMapper.mapp(snakeRepository.findById(id));
    }

    @Override
    public SnakeDto createSnake(SnakeDto snake) {
        if (snake.getName().isEmpty())
            throw new RuntimeException();

        return snakeMapper.mapp(snakeRepository.save(snakeMapper.mapp(snake)));
    }


    @Override
    public void deleteSnake(Integer id) {
        snakeRepository.deleteById(id);
    }


    @Override
    public SnakeDto replaceSnake(Integer id, SnakeDto snakeDto) {
        Optional<Snake> snake = snakeRepository.findById(id);

        if (snake.isPresent()) {
            Snake updatedSnake = snake.get();
            updatedSnake.setName(snakeDto.getName());
            updatedSnake.setType((snakeDto.getType()));
            updatedSnake.setWeight(snakeDto.getWeight());
            updatedSnake.setGender(snakeDto.getGender());
            return snakeMapper.mapp(snakeRepository.save(updatedSnake));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Id " + id + " not found");
        }

    }

    @Override
    public SnakeDto updateSnake(Integer id, SnakeType snakeType) {
        Optional<Snake> snake = snakeRepository.findById(id);

        if (snake.isPresent()) {

            Snake updatedSnake = snake.get();
            ;
            if (snakeType.type != null)
                updatedSnake.setType(snakeType.type);


            return snakeMapper.mapp(snakeRepository.save(updatedSnake));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Id " + id + " not found");
        }
    }
}
