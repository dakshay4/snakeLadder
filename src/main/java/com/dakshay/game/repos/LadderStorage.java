package com.dakshay.game.repos;

import com.dakshay.game.models.Base;
import com.dakshay.game.models.Ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderStorage<T extends Base> implements GameStorageFactory<Ladder, String> {

    private final Map<String, Ladder> ladderData;


    public Map<String, Ladder> getLadderData() {
        return ladderData;
    }

    public LadderStorage() {
        this.ladderData = new HashMap<>();
    }

    @Override
    public Ladder save(Ladder ladder) {
        ladderData.put(ladder.getId(), ladder);
        return ladder;
    }

    @Override
    public List<Ladder> getAll() {
        return new ArrayList<>(ladderData.values());
    }

    @Override
    public Ladder getById(String id) {
        return ladderData.get(id);
    }

    @Override
    public Ladder update(Ladder ladder) {
        return null;
    }

}