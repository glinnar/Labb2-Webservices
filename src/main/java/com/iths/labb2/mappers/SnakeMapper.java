package com.iths.labb2.mappers;

import com.iths.labb2.dtos.SnakeDto;
import com.iths.labb2.entities.Snake;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SnakeMapper {
    public SnakeMapper() {
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

    public List<SnakeDto> mapp(List<Snake> all) {

        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());

    }
}