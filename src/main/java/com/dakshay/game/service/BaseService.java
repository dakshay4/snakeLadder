package com.dakshay.game.service;

import com.dakshay.game.models.Player;

import java.util.List;

public interface BaseService<T>{

    public List<T> create(List<T> t);
    public T create(T t);

    public T update(T t);

    List<T> getAll();
}
