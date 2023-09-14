package com.dakshay.game.models;

import java.util.Random;

public class Dice {
    private final int start;
    private final int end;

    public Dice(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int rollDice() {
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(end+1);
            if(rand > start) break;
        }
//        System.out.println(rand);
        return rand;
    }
}
