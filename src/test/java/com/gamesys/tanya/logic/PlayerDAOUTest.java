package com.gamesys.tanya.logic;

import com.gamesys.tanya.api.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class PlayerDAOUTest {
    PlayerDAO playerTable;

    @Before
    public void setUp() throws SQLException {
        playerTable = new PlayerDAO();
        playerTable.createTable();
        playerTable.setTableIdToStartAt100();
    }

    @After
    public void tearDown() throws SQLException {
        playerTable.dropTable();
    }

    @Test
    public void testSavingPlayer() throws SQLException {
        Player player = new Player("tanya", "powell", 1, 1, 2, 3);
        PlayerDAO.saveNewPlayer(player);

        Assert.assertThat(playerTable.isEmpty(), is(false));
    }

    @Test
    public void testGetAllPlayersInTable() throws SQLException {
        Player player1 = new Player("t", "powell", 0, 0, 0, 0);
        Player player2 = new Player("a", "powell", 0, 0, 0, 0);
        Player player3 = new Player("b", "powell", 0, 0, 0, 0);
        Player player4 = new Player("c", "powell", 0, 0, 0, 0);
        PlayerDAO.saveNewPlayer(player1);
        PlayerDAO.saveNewPlayer(player2);
        PlayerDAO.saveNewPlayer(player3);
        PlayerDAO.saveNewPlayer(player4);

        List<Player> expectedList = new ArrayList<>();
        expectedList.add(player1);
        expectedList.add(player2);
        expectedList.add(player3);
        expectedList.add(player4);

        Assert.assertEquals(expectedList, playerTable.getAll());
    }

    @Test
    public void testGetByPlayerId() throws SQLException {
        Player player1 = new Player("t", "powell", 0, 0, 0, 0);
        Player player2 = new Player("a", "powell", 0, 0, 0, 0);
        Player player3 = new Player("b", "powell", 0, 0, 0, 0);
        Player player4 = new Player("c", "powell", 0, 0, 0, 0);
        PlayerDAO.saveNewPlayer(player1);
        PlayerDAO.saveNewPlayer(player2);
        PlayerDAO.saveNewPlayer(player3);
        PlayerDAO.saveNewPlayer(player4);

        List<Player> expectedList = new ArrayList<>();
        expectedList.add(player2);

        System.out.println(expectedList);
        System.out.println(playerTable.getByPlayerId(102));

        Assert.assertTrue(expectedList.containsAll(playerTable.getByPlayerId(101)) && playerTable.getByPlayerId(101).containsAll(expectedList));
    }

    @Test
    public void testPlayerTableIsEmpty() throws SQLException {
        Assert.assertTrue(playerTable.isEmpty());
    }
}