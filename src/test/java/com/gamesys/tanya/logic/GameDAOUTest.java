package com.gamesys.tanya.logic;

import com.gamesys.tanya.api.Game;
import com.gamesys.tanya.api.Player;
import org.junit.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAOUTest {
    private PlayerDAO playerDAO;
    private GameDAO gameDAO;

    @Before
    public void setUp() throws SQLException {
        playerDAO = new PlayerDAO();
        playerDAO.createTable();
//        playerDAO.setTableIdToStartAt100();
        gameDAO = new GameDAO();
        gameDAO.createTable();
        gameDAO.setTableIdToStartAt100();
    }

    @After
    public void tearDown() throws SQLException {
        playerDAO.dropTable();
        gameDAO.dropTable();
    }

    @Test
    public void testGetTotalNumberOfGamesPlayed() throws SQLException {
        Player player1 = new Player("tans", "pow", 5, 3, 2, 1);
        PlayerDAO.saveNewPlayer(player1);

        Game game1 = new Game();
        Game game2 = new Game();
        GameDAO.saveGameResults(game1);
        GameDAO.saveGameResults(game2);

        List<Game> expectedList = new ArrayList<>();
        expectedList.add(game1);
        expectedList.add(game2);

        Assert.assertEquals(expectedList.size(), gameDAO.getTotalNumberOfGamesPlayed());
    }

    @Test
    public void testGetAll() throws SQLException {
        Player player = new Player("tans", "pow", 5, 3, 2, 1);
        PlayerDAO.saveNewPlayer(player);

        Game game1 = new Game();
        Game game2 = new Game();
        Game game3 = new Game();
        Game game4 = new Game();
        Game game5 = new Game();

        GameDAO.saveGameResults(game1);
        GameDAO.saveGameResults(game2);
        GameDAO.saveGameResults(game3);
        GameDAO.saveGameResults(game4);
        GameDAO.saveGameResults(game5);

        List<Game> expectedList = new ArrayList<>();
        expectedList.add(game1);
        expectedList.add(game2);
        expectedList.add(game3);
        expectedList.add(game4);
        expectedList.add(game5);

        Assert.assertEquals(expectedList.containsAll(gameDAO.getAll()), gameDAO.getAll().containsAll(expectedList));
    }

    @Test
    public void testGetGamesByPlayerId() throws SQLException {
        Player player1 = new Player("tans", "pow", 5, 3, 2, 1);
        PlayerDAO.saveNewPlayer(player1);

        Game game1 = new Game();
        Game game2 = new Game();
        Game game3 = new Game();
        Game game4 = new Game();
        Game game5 = new Game();

        GameDAO.saveGameResults(game1);
        GameDAO.saveGameResults(game2);
        GameDAO.saveGameResults(game3);
        GameDAO.saveGameResults(game4);
        GameDAO.saveGameResults(game5);

        List<Game> expectedList = new ArrayList<>();
        expectedList.add(game2);

        System.out.println(expectedList);
        System.out.println(GameDAO.getByPlayerId(100));

        Assert.assertEquals(expectedList.containsAll(GameDAO.getByPlayerId(100)), GameDAO.getByPlayerId(100).containsAll(expectedList));
    }

    @Test
    public void testGetByGameId() throws SQLException {
        Player player1 = new Player("tans", "pow", 5, 3, 2, 1);
        PlayerDAO.saveNewPlayer(player1);

        Game game1 = new Game(true);
        Game game2 = new Game(false);
        Game game3 = new Game(true);
        Game game4 = new Game(false);
        Game game5 = new Game(true);

        GameDAO.saveGameResults(game1);
        GameDAO.saveGameResults(game2);
        GameDAO.saveGameResults(game3);
        GameDAO.saveGameResults(game4);
        GameDAO.saveGameResults(game5);

        List<Game> expectedList = new ArrayList<>();
        expectedList.add(game2);

        System.out.println(GameDAO.getById(100));
//        System.out.println(expectedList);
//        Assert.assertTrue(GameDAO.getById(101).containsAll(expectedList));
    }

}
