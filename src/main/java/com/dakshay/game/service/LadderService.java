package com.dakshay.game.service;

import com.dakshay.game.models.Snake;
import com.dakshay.game.repos.GameStorageFactory;
import com.dakshay.game.models.Ladder;
import com.dakshay.game.repos.LadderStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderService implements BaseService<Ladder> {

    private final GameStorageFactory<Ladder,String> ladderStorage;

    public LadderService() {
        this.ladderStorage = new LadderStorage<Ladder>();
    }

    public List<Ladder> create(List<Ladder> ladders) {
         ladders.forEach(ladderStorage::save) ;
         return ladders;
    }

    public Ladder create(Ladder ladder) {
        return ladderStorage.save(ladder);
    }

    @Override
    public Ladder update(Ladder ladder) {
        return null;
    }

    @Override
    public List<Ladder> getAll() {
        return ladderStorage.getAll();
    }

    public Map<Integer, Integer> getLadders() {
        Map<Integer, Integer> ladders = new HashMap<>();
        return ladderStorage.getAll().stream().collect(Collectors.toMap(Ladder::getStart, Ladder::getEnd));
    }
}
