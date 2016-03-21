package com.gamesys.tanya.logic;

import com.gamesys.tanya.api.Game;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDBUTest {
    private GameDB database;

    @Before
    public void setUp() throws SQLException {
        database = new GameDB();
        database.createTable();
    }

    @After
    public void tearDown() throws SQLException {
        database.dropTable();
    }

    @Test
    public void testGetTotalNumberOfGamesPlayed() throws SQLException {
        Game game1 = new Game(123, 3214);
        Game game2 = new Game(231, 3214);
        GameDB.saveGameResults(game1);
        GameDB.saveGameResults(game2);

        Assert.assertEquals(2, database.getTotalNumberOfGamesPlayed());
    }

//    @Test
//    public void testGetAll() throws SQLException {
//        Game game1 = new Game(123, 3241);
//        Game game2 = new Game(456, 3241);
//        Game game3 = new Game(321, 5642);
//        Game game4 = new Game(965, 5642);
//        Game game5 = new Game(585, 5642);
//
//        GameDB.saveGameResults(game1);
//        GameDB.saveGameResults(game2);
//        GameDB.saveGameResults(game3);
//        GameDB.saveGameResults(game4);
//        GameDB.saveGameResults(game5);
//
//        List<Game> list = new ArrayList<>();
//        list.add(game1);
//        list.add(game2);
//        list.add(game3);
//        list.add(game4);
//        list.add(game5);
//
//        System.out.println(list);
//        Assert.assertTrue(list.containsAll(database.getAll()) && database.getAll().containsAll(list));
//    }
//
//    @Test
//    public void testGetGamesByPlayerId() throws SQLException {
//        Game game1 = new Game(123, 3241);
//        Game game2 = new Game(456, 3241);
//        Game game3 = new Game(321, 5642);
//        Game game4 = new Game(965, 5642);
//        Game game5 = new Game(585, 5642);
//
//        GameDB.saveGameResults(game1);
//        GameDB.saveGameResults(game2);
//        GameDB.saveGameResults(game3);
//        GameDB.saveGameResults(game4);
//        GameDB.saveGameResults(game5);
//
//        List<Game> list = new ArrayList<>();
//        list.add(game1);
//        list.add(game2);
//
//        long player = game1.getPlayerId();
//        System.out.println(database.getByPlayerId(player));
//        System.out.println(list);
//
//        Assert.assertEquals(list.containsAll(database.getByPlayerId(player)), database.getByPlayerId(player).containsAll(list));
//    }
//
//    @Test
//    public void testGetByGameId() throws SQLException {
//        Game game1 = new Game(123, 3241);
//        Game game2 = new Game(456, 3241);
//        Game game3 = new Game(321, 5642);
//        Game game4 = new Game(965, 5642);
//        Game game5 = new Game(585, 5642);
//
//        GameDB.saveGameResults(game1);
//        GameDB.saveGameResults(game2);
//        GameDB.saveGameResults(game3);
//        GameDB.saveGameResults(game4);
//        GameDB.saveGameResults(game5);
//
//        List<Game> list = new ArrayList<>();
//        list.add(game1);
//
//        Assert.assertTrue(list.containsAll(database.getById(123)) && database.getById(123).containsAll(list));
//    }

}
