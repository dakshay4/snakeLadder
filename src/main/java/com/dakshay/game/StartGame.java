package com.dakshay.game;

import com.dakshay.game.models.*;
import com.dakshay.game.service.BoardService;
import com.dakshay.game.service.LadderService;
import com.dakshay.game.service.PlayerService;
import com.dakshay.game.service.SnakeService;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StartGame {
    private final BoardService boardService;
    private final PlayerService playerService;
    private final LadderService ladderService;
    private final SnakeService snakeService;

    public StartGame() {
        this.playerService = new PlayerService();
        this.ladderService = new LadderService();
        this.snakeService = new SnakeService();
        List<Player> players = getPlayersList();
        List<Snake> snakes = getSnakesList();
        List<Ladder> ladders = getLadderList();
        Dice dice = new Dice(1,6);
        this.boardService = new BoardService(players,snakes,ladders,dice);
    }

    public static void main(String[] args) {
        StartGame startGame = new StartGame();
        startGame.run();

    }

    private void run() {
        System.out.println("There are total " + boardService.getBoard().getPlayers().size() + " Players");
        List<Player> players = playerService.getAll();
        int totalPlayers = players.size();
        Set<String> outPlayers = new HashSet<>();
        String winnerPlayerId = null;
        while(winnerPlayerId==null) {
            for(int i=1;i<=totalPlayers;i++) {
                Player currentPlayer = players.get(i-1);
                if(outPlayers.contains(currentPlayer.getId())) continue;
                int diceRoll = boardService.getBoard().getDice().rollDice();
                System.out.println("Player " + currentPlayer.getName() +
                        " Turn, Current Pos : " + currentPlayer.getPosition()  + ", Dice Roll <> " + diceRoll);
                int newPos = getNewPosition(currentPlayer, diceRoll);
                boolean isPlayedOut = isPlayedOut(newPos);
                if(isPlayedOut) outPlayers.add(currentPlayer.getId());
                boolean isGameOver = isGameOver(newPos);
                if(isGameOver) {
                    winnerPlayerId = currentPlayer.getId();
                    break;
                }
                currentPlayer.setPosition(newPos);
                playerService.update(currentPlayer);
            }
        }
        System.out.println("Winner is " +
                playerService.players().get(winnerPlayerId).getName());
    }

    private boolean isPlayedOut(int newPos) {
        return newPos > boardService.getBoard().getSize();
    }

    private boolean isGameOver(int newPos) {
        return newPos == boardService.getBoard().getSize();
    }

    private int getNewPosition(Player currentPlayer, int diceRoll) {
        int newPos = currentPlayer.getPosition()+diceRoll;
        Map<Integer, Integer> snakes = snakeService.getSnakesHead();
        Map<Integer, Integer> ladders = ladderService.getLadders();
        if (snakes.containsKey(newPos)) newPos = snakes.get(newPos);
        if (ladders.containsKey(newPos)) newPos = ladders.get(newPos);
        return newPos;
    }

    private List<Player> getPlayersList() {
        return playerService.create(List.of(new Player("Dakshay", 0),
                new Player("Dakshana", 0)));
    }

    private List<Ladder> getLadderList() {
        return ladderService.create(List.of(
                new Ladder(1,38),
                new Ladder(4,14),
                new Ladder(9,31),
                new Ladder(21,42),
                new Ladder(28,84),
                new Ladder(51,67),
                new Ladder(72,91),
                new Ladder(80,99)));
    }

    private List<Snake> getSnakesList() {
        return snakeService.create(List.of(
                new Snake(17,7),
                new Snake(62,19),
                new Snake(54,34),
                new Snake(87,36),
                new Snake(64,60),
                new Snake(95,75),
                new Snake(93,73),
                new Snake(98,79)));

    }
}
