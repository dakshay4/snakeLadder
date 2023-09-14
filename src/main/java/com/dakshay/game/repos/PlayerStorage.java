package com.dakshay.game.repos;

import com.dakshay.game.models.Base;
import com.dakshay.game.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerStorage<T extends Base> implements GameStorageFactory<Player, String> {

    private final Map<String, Player> playerData;


    public Map<String, Player> getPlayerData() {
        return playerData;
    }

    public PlayerStorage() {
        this.playerData = new HashMap<>();
    }

    @Override
    public Player save(Player player) {
        playerData.put(player.getId(), player);
        return player;
    }

    @Override
    public List<Player> getAll() {
        return new ArrayList<>(playerData.values());
    }

    @Override
    public Player getById(String id) {
        return playerData.get(id);
    }

    @Override
    public Player update(Player player) {
        playerData.put(player.getId(), player);
        return player;
    }
}
