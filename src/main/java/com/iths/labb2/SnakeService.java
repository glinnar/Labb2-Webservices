package com.iths.labb2;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SnakeService {
    private SnakeRepository snakeRepository;

    public SnakeService(SnakeRepository snakeRepository) {
        this.snakeRepository = snakeRepository;
    }

    public List<SnakeDto> getAllSnakes() {
        return mapp(snakeRepository.findAll());
    }

    public Optional<SnakeDto> getOne(Integer id) {
        return mapp(snakeRepository.findById(id));
    }

    public SnakeDto createSnake(SnakeDto snake) {
        if (snake.getName().isEmpty())
            throw new RuntimeException();

        return mapp(snakeRepository.save(mapp(snake)));
    }

    public SnakeDto mapp(Snake snake) {
        return new SnakeDto(snake.getId(), snake.getName(), snake.getType(), snake.getWeight(), snake.getGender());

    }

    public Snake mapp(SnakeDto snakeDto) {

        return new Snake(snakeDto.getId(), snakeDto.getName(), snakeDto.getType(),
                snakeDto.getWeight(), snakeDto.getGender());

    }

    public Optional<SnakeDto> mapp(Optional<Snake> optionalSnake) {
        if (optionalSnake.isEmpty())
            return Optional.empty();

        return Optional.of(mapp(optionalSnake.get()));

    }

    private List<SnakeDto> mapp(List<Snake> all) {

        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
   /*     List<SnakeDto> snakeDtosList = new ArrayList<>();
        for (var snake : all) {
            snakeDtosList.add(mapp(snake));
        }
        return snakeDtosList;
    }*/


    }
}
