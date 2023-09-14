package com.dakshay.game.repos;

import com.dakshay.game.models.Base;

import java.util.List;
import java.util.Map;

public interface GameStorageFactory<T,I> {

    public T save(T t);

    public List<T> getAll();

    public T getById(I id);
    public T update(T t);




}
