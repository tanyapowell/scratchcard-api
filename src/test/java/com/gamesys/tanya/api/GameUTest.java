package com.gamesys.tanya.api;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameUTest {
    Game game;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {}

    @Test
    public void testGetResults(){
        game = new Game(123, 96521);
        boolean bool = game.getResult();
        Assert.assertEquals(true, bool);
    }

    @Test
    public void testSetPlayerId(){
        game = new Game(0,0);
        game.setPlayerId(656);
        Assert.assertTrue(game.getPlayerId() == 656);
    }

    @Test
    public void testGetPlayerId(){
        game = new Game(459, 45695);
        long playerId = game.getPlayerId();
        Assert.assertEquals(playerId, 45695);
    }

    @Test
    public void testSetGameId(){
        game = new Game(0,0);
        game.setId(78909);
        Assert.assertTrue(game.getId() == 78909);
    }

    @Test
    public void testGetGameId(){
        game = new Game(548, 45695);
        long gameId = game.getId();
        Assert.assertEquals(gameId, 548);
    }

    @Test
    public void testEqualsAndHashcode(){
        Game game = new Game(1, 123);
        Game sameGame = new Game(1, 123);
        Game similarGame = new Game(2, 123);

        Assert.assertTrue(game.equals(sameGame));
        Assert.assertTrue(game.hashCode() == sameGame.hashCode());

        Assert.assertFalse(game.equals(null));
        Assert.assertFalse(game.equals(similarGame));
        Assert.assertTrue(game.hashCode() != similarGame.hashCode());
    }

}
