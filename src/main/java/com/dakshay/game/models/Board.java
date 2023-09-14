package com.dakshay.game.models;

import java.util.List;
import java.util.UUID;

public class Board extends Base{

    private final int start;
    private final int size;
    private final List<Player> players;
    private final List<Snake> snakes;
    private final List<Ladder> ladders;

    private final Dice dice;

    public Board(int start, int size, List<Player> players, List<Snake> snakes, List<Ladder> ladders, Dice dice) {
        super(UUID.randomUUID().toString());
        this.start = start;
        this.size = size;
        this.players = players;
        this.snakes = snakes;
        this.ladders = ladders;
        this.dice = dice;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getStart() {
        return start;
    }

    public int getSize() {
        return size;
    }

    public Dice getDice() {
        return dice;
    }
}
