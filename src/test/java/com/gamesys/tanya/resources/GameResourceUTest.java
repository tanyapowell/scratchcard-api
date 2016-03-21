package com.gamesys.tanya.resources;

import com.gamesys.tanya.api.Game;
import com.gamesys.tanya.logic.GameDB;
import com.google.gson.Gson;
import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameResourceUTest {
    private GameResource resource;
    private GameDB database;

    @Before
    public void setUp() throws SQLException {
        database = new GameDB();
//        database.createTable();
        resource = new GameResource(database);
    }

    @After
    public void tearDown() throws SQLException {
        database.dropTable();
    }

//    @Test
//    public void testGetAllGames() throws SQLException {
//        List<Game> list = new ArrayList<>();
//
//        Game game1 = new Game(1234, 453241);
//        Game game2 = new Game(2315, 123241);
//        Game game3 = new Game(3890, 563241);
//        Game game4 = new Game(4255, 695379);
//        Game game5 = new Game(6932, 897642);
//        Game game6 = new Game(8003, 789649);
//        GameDB.saveGameResults(game1);
//        GameDB.saveGameResults(game2);
//        GameDB.saveGameResults(game3);
//        GameDB.saveGameResults(game4);
//        GameDB.saveGameResults(game5);
//        GameDB.saveGameResults(game6);
//
//        list.add(game1);
//        list.add(game2);
//        list.add(game3);
//        list.add(game4);
//        list.add(game5);
//        list.add(game6);
//
//        Gson gson = new Gson();
//        String jsonList = gson.toJson(list);
//
//        Assert.assertEquals(jsonList, resource.getGames());
//    }

    @Test
    public void testSavingGame() throws SQLException {
        Game game = new Game(5555, 453241);
        String save = resource.addNewGame(game);

        Assertions.assertThat(save).isEqualTo("Game has been saved");

    }

//    @Test
//    public void testGetByGameID() throws SQLException {
//        List<Game> list = new ArrayList<>();
//
//        Game game1 = new Game(1234, 453241);
//        Game game2 = new Game(2315, 123241);
//        Game game3 = new Game(3890, 563241);
//        Game game4 = new Game(4255, 695379);
//        Game game5 = new Game(6932, 897642);
//        Game game6 = new Game(8003, 789649);
//        GameDB.saveGameResults(game1);
//        GameDB.saveGameResults(game2);
//        GameDB.saveGameResults(game3);
//        GameDB.saveGameResults(game4);
//        GameDB.saveGameResults(game5);
//        GameDB.saveGameResults(game6);
//
//        list.add(game1);
//
//        Gson gson = new Gson();
//        String jsonList = gson.toJson(list);
//
//        Assert.assertEquals(jsonList, resource.getById(1234));
//
//    }
//
//    @Test
//    public void testGetByPlayerID() throws SQLException {
//        List<Game> list = new ArrayList<>();
//
//        Game game1 = new Game(1234, 453241);
//        Game game2 = new Game(2315, 123241);
//        Game game3 = new Game(3890, 563241);
//        Game game4 = new Game(4255, 695379);
//        Game game5 = new Game(6932, 897642);
//        Game game6 = new Game(8003, 789649);
//        GameDB.saveGameResults(game1);
//        GameDB.saveGameResults(game2);
//        GameDB.saveGameResults(game3);
//        GameDB.saveGameResults(game4);
//        GameDB.saveGameResults(game5);
//        GameDB.saveGameResults(game6);
//
//        list.add(game1);
//
//        Gson gson = new Gson();
//        String jsonList = gson.toJson(list);
//
//        Assert.assertEquals(jsonList, resource.getByPlayer(453241));
//    }
}
