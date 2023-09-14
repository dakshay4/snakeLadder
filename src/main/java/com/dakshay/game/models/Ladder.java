package com.dakshay.game.models;

import java.util.UUID;

public class Ladder extends Base{
    private int start;
    private int end;

    public Ladder(int start, int end) {
        super(UUID.randomUUID().toString());
        this.start = start;
        this.end = end;
    }


    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
