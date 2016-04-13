package com.gamesys.tanya.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gamesys.tanya.logic.PlayerDAO;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    Player player = new Player();
    private long playerId;
    private boolean result;

    // init for new Game
    public Game() {
        this.playerId = getPlayerId();
        this.result = getResult();
    }

    // init for Game loaded from DB
    public Game(boolean result) {
        this.playerId = getPlayerId();
        this.result = result;
    }

    @JsonProperty
    public long getPlayerId() {
        return player.getId();
    }

    @JsonProperty
    public boolean getResult() {
        Random random = new Random();

        if (random.nextBoolean() == true) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @JsonProperty
    public boolean doesPlayerHaveEnoughTicketsToPlay(Player player) {
                boolean canPlay;
        if(player.getTotalNumberOfGamesAvailableToPlay() > 0) {
            canPlay = true;
        }
        else {
            canPlay = false;
        }

        return canPlay;
    }

    public void playGame(Player player){
        if(doesPlayerHaveEnoughTicketsToPlay(player)){
            player.setTotalNumberOfGamesPlayed();
            player.setTotalNumberOfGamesAvailableToPlayAfterGamePlay();
        }
        else {
            System.out.println("you ain't got enough tickets bruh");
        }

        if(getResult()){
            player.setNumberOfWins();
        }
        else {
            player.setNumberOfLosses();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (playerId != game.playerId) return false;
        if (result != game.result) return false;
        return player != null ? player.equals(game.player) : game.player == null;

    }

    @Override
    public int hashCode() {
        int result1 = player != null ? player.hashCode() : 0;
        result1 = 31 * result1 + (int) (playerId ^ (playerId >>> 32));
        result1 = 31 * result1 + (result ? 1 : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "Game{" +
                "player=" + player +
                ", playerId=" + playerId +
                ", result=" + result +
                '}';
    }

}
