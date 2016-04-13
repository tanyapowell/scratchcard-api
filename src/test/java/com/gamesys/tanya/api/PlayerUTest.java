package com.gamesys.tanya.api;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerUTest {
    Player player;

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    @Test
    public void testGetPlayersFirstName() {
        player = new Player("tanya", "powell", 0, 0, 0, 0);
        Assert.assertEquals("tanya", player.getFirstName());
    }

    @Test
    public void testSetPlayersFirstName() {
        player = new Player("", "", 0, 0, 0, 0);
        player.setFirstName("tanya");
        Assert.assertTrue(player.getFirstName() == "tanya");
    }

    @Test
    public void testGetPlayersLastName() {
        player = new Player("tanya", "powell", 0, 0, 0, 0);
        Assert.assertEquals("powell", player.getLastName());
    }

    @Test
    public void testSetPlayersLastName() {
        player = new Player("", "", 0, 0, 0, 0);
        player.setLastName("powell");
        Assert.assertTrue(player.getLastName() == "powell");
    }

//    @Test
//    public void testGetPlayerId() {
//        player = new Player("tanya", "powell", 0, 0, 0, 0);
//        Assert.assertEquals(1, player.getId());
//    }

    @Test
    public void testBuyATicketAndTotalTicketsHaveIncremented() {
        player = new Player("", "", 1, 0, 0, 0);
        player.buyTickets(3);
        Assert.assertEquals(4, player.getTotalNumberOfGamesAvailableToPlay());
    }

    @Test
    public void testTotalWinsEqualsFive() {
        player = new Player("", "", 0, 0, 5, 0);
        Assert.assertEquals(5, player.getNumberOfWins());

    }

    @Test
    public void testTotalLossesEqualsFifteen() {
        player = new Player("", "", 0, 0, 0, 15);
        Assert.assertEquals(15, player.getNumberOfLosses());
    }

    @Test
    public void testPlayerNumberOfGameLossesIncreasesWhenGameIsLost() {
        player = new Player("", "", 0, 0, 0, 0);
        player.setNumberOfLosses();
        Assert.assertEquals(1, player.getNumberOfLosses());
    }

    @Test
    public void testPlayerNumberOfGameWinsIncreasesWhenGameIsWon() {
        player = new Player("", "", 0, 0, 0, 0);
        player.setNumberOfWins();
        Assert.assertEquals(1, player.getNumberOfWins());
    }

    @Test
    public void testGettingTotalNumberOfGamesAvailableToPlay() {
        player = new Player("", "", 100, 0, 0, 0);
        Assert.assertEquals(100, player.getTotalNumberOfGamesAvailableToPlay());
    }

    @Test
    public void testSettingTotalNumberOfGamesAvailableToPlay() {
        player = new Player("", "", 100, 0, 0, 0);
        Assert.assertEquals(100, player.getTotalNumberOfGamesAvailableToPlay());
    }

    @Test
    public void testGetTotalNumberOfGamesPlayed() {
        player = new Player("", "", 0, 5, 0, 0);
        Assert.assertEquals(5, player.getTotalNumberOfGamesPlayed());
    }

    @Test
    public void testSetTotalNumberOfGamesPlayed() {
        player = new Player("", "", 0, 0, 0, 0);
        player.setTotalNumberOfGamesPlayed();
        Assert.assertEquals(1, player.getTotalNumberOfGamesPlayed());
    }

    @Test
    public void testEqualsAndHashcode(){
        player = new Player("tanya", "powell", 0, 0, 0, 0);
        Player samePlayer = new Player("tanya", "powell", 0, 0, 0, 0);
        Player similarPlayer = new Player("tanya1", "powell", 0, 0, 0, 0);

        Assert.assertTrue(player.equals(samePlayer));
        Assert.assertTrue(player.hashCode() == samePlayer.hashCode());

        Assert.assertFalse(player.equals(null));
        Assert.assertFalse(player.equals(similarPlayer));
        Assert.assertTrue(player.hashCode() != similarPlayer.hashCode());
    }

}
