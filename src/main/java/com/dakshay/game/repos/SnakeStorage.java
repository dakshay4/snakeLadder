package com.dakshay.game.repos;

import com.dakshay.game.models.Base;
import com.dakshay.game.models.Snake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeStorage<T extends Base> implements GameStorageFactory<Snake, String> {

    private final Map<String, Snake> snakeData;


    public Map<String, Snake> getSnakeData() {
        return snakeData;
    }

    public SnakeStorage() {
        this.snakeData = new HashMap<>();
    }

    @Override
    public Snake save(Snake snake) {
        snakeData.put(snake.getId(), snake);
        return snake;
    }

    @Override
    public List<Snake> getAll() {
        return new ArrayList<>(snakeData.values());
    }

    @Override
    public Snake getById(String id) {
        return snakeData.get(id);
    }

    @Override
    public Snake update(Snake snake) {
        return null;
    }
}