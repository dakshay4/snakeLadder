package com.dakshay.game.service;

import com.dakshay.game.repos.GameStorageFactory;
import com.dakshay.game.models.Player;
import com.dakshay.game.repos.PlayerStorage;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayerService implements BaseService<Player>{

    private final GameStorageFactory<Player,String> playerStorage;

    public PlayerService() {
        this.playerStorage = new PlayerStorage<Player>();
    }

    public List<Player> create(List<Player> players) {
        players.forEach(playerStorage::save) ;
        return players;
    }

    public Player create(Player player) {
        return playerStorage.save(player);
    }

    @Override
    public Player update(Player player) {
       return playerStorage.update(player);
    }

    @Override
    public List<Player> getAll() {
        return playerStorage.getAll();
    }

    public Map<String, Player> players() {
        return playerStorage.getAll().stream().collect(Collectors.toMap(Player::getId, Function.identity()));
    }
}
