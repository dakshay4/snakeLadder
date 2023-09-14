package com.dakshay.game.service;

import com.dakshay.game.models.Ladder;
import com.dakshay.game.models.Snake;
import com.dakshay.game.repos.SnakeStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SnakeService implements BaseService<Snake>{

    private final SnakeStorage<Snake> snakeStorage;

    public SnakeService() {
        this.snakeStorage = new SnakeStorage<>();
    }

    @Override
    public List<Snake> create(List<Snake> snakes) {
        snakes.forEach(snakeStorage::save);
        return snakes;
    }

    @Override
    public Snake create(Snake snake) {
        return snakeStorage.save(snake);
    }

    @Override
    public Snake update(Snake snake) {
        return snakeStorage.update(snake);
    }

    @Override
    public List<Snake> getAll() {
        return snakeStorage.getAll();
    }

    public Map<Integer, Integer> getSnakesHead() {
        Map<Integer, Integer> snakeHead = new HashMap<>();
        return snakeStorage.getAll().stream().collect(Collectors.toMap(Snake::getHead, Snake::getTail));
    }
}
