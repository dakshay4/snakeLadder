package com.dakshay.game.models;

import java.util.UUID;

public class Player extends Base{

    private final String name;

    private int position;

    public Player(String name, int position) {
        super(UUID.randomUUID().toString());
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void changePlayerPosition(int newPosition) {
        this.position = newPosition;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", id='" + getId() + '\'' +
                "} " + super.toString();
    }
}
