package com.dakshay.game.service;

import com.dakshay.game.repos.GameStorageFactory;
import com.dakshay.game.models.*;
import com.dakshay.game.repos.BoardStorage;

import java.util.List;

public class BoardService {


    private final Board board;

    private final GameStorageFactory<Board,String> boardMapStorage;

    public BoardService(List<Player> players, List<Snake> snakes, List<Ladder> ladders, Dice dice) {
        this.board = new Board(1,100, players, snakes, ladders, dice);
        this.boardMapStorage = new BoardStorage();
    }

    public Board getBoard() {
        return board;
    }

    public void movePosition(String playerId, Integer position) {

    }
}
