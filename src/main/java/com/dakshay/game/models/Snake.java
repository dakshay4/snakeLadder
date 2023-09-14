package com.dakshay.game.models;

import java.util.UUID;

public class Snake extends Base{

    private int head;
    private int tail;

    public Snake(int head, int tail) {
        super(UUID.randomUUID().toString());
        this.head = head;
        this.tail = tail;
    }


    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }
}
