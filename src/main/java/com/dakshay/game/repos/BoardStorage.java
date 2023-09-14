package com.dakshay.game.repos;

import com.dakshay.game.models.Board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardStorage implements GameStorageFactory<Board, String> {

    private final Map<String, Board> boardData;

    public BoardStorage() {
        this.boardData = new HashMap<>();
    }

    @Override
    public Board save(Board board) {
        return null;
    }

    @Override
    public List<Board> getAll() {
        return new ArrayList<>(boardData.values());
    }

    @Override
    public Board getById(String id) {
        return boardData.get(id);
    }

    @Override
    public Board update(Board board) {
        return null;
    }
}
