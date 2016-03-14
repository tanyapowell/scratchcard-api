package com.gamesys.tanya.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

public class Game {
    private long playerId;
    private boolean result;
    private long id;

    public Game(int id, long playerId) {
        this.id = id;
        this.playerId = playerId;
        result = getResult();
    }

    @JsonProperty
    public boolean getResult() {
        boolean result;
        Random random = new Random();

        if (random.nextBoolean() == true) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @JsonProperty
    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Game{" +
                "playerId=" + playerId +
                ", result=" + result +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (playerId != game.playerId) return false;
        if (result != game.result) return false;
        return id == game.id;

    }

    @Override
    public int hashCode() {
        int result1 = (int) (playerId ^ (playerId >>> 32));
        result1 = 31 * result1 + (result ? 1 : 0);
        result1 = 31 * result1 + (int) (id ^ (id >>> 32));
        return result1;
    }
}
