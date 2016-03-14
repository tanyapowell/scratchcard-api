package com.gamesys.tanya.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerUTest {
    Player player;

    @Before
    public void setUp() {

    }

    @Test
    public void testGetPlayersFirstName(){
        player = new Player("tanya", "powell", 10);
        Assert.assertEquals("tanya", player.getFirstname());
    }

    @Test
    public void testSetPlayersFirstName(){
        player = new Player("", "", 0);
        player.setFirstname("tanya");
        Assert.assertTrue(player.getFirstname() == "tanya");
    }

    @Test
    public void testGetPlayersLastName(){
        player = new Player("tanya", "powell", 10);
        Assert.assertEquals("powell", player.getLastname());
    }

    @Test
    public void testSetPlayersLastName(){
        player = new Player("", "", 0);
        player.setLastname("powell");
        Assert.assertTrue(player.getLastname() == "powell");
    }

    @Test
    public void testGetPlayerId(){
        player = new Player("tanya", "powell", 10);
        Assert.assertEquals(10, player.getId());
    }

    @Test
    public void testSetPlayerId(){
        player = new Player("", "", 0);
        player.setId(55);
        Assert.assertTrue(player.getId() == 55);
    }

    @Test
    public void testEqualsAndHashcode(){
        player = new Player("tanya", "powell", 10);
        Player samePlayer = new Player("tanya", "powell", 10);
        Player similarPlayer = new Player("tanya", "powell", 45);

        Assert.assertTrue(player.equals(samePlayer));
        Assert.assertTrue(player.hashCode() == samePlayer.hashCode());

        Assert.assertFalse(player.equals(null));
        Assert.assertFalse(player.equals(similarPlayer));
        Assert.assertTrue(player.hashCode() != similarPlayer.hashCode());
    }

}
