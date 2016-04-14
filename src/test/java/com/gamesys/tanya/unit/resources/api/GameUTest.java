package com.gamesys.tanya.unit.resources.api;

import com.gamesys.tanya.api.Game;
import com.gamesys.tanya.api.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameUTest {
    Game game;

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    @Test
    public void testWin(){
        game = new Game(true);
        boolean bool = game.getResult();
        Assert.assertEquals(true, bool);
    }

    @Test
    public void testLoss(){
        game = new Game(false);
        boolean bool = game.getResult();
        Assert.assertEquals(false, bool);
    }


    @Test
    public void testPlayerDoesNotHaveEnoughTicketsToPlay(){
        game = new Game();
        Player player = new Player("", "", 0, 0, 0, 0);
        Assert.assertFalse(game.doesPlayerHaveEnoughTicketsToPlay(player));
    }

    @Test
    public void testPlayerHasEnoughTicketsToPlay(){
        game = new Game();
        Player player = new Player("", "", 1, 0, 0, 0);
        Assert.assertTrue(game.doesPlayerHaveEnoughTicketsToPlay(player));
    }

    @Test
    public void testNumberOfGamesPlayedHasIncrementedDuringGamePlay() {
        game = new Game();
        Player player = new Player("", "", 1, 0, 0, 0);
        game.playGame(player);
        Assert.assertEquals(1, player.getTotalNumberOfGamesPlayed());
    }

    @Test
    public void testTotalNumberOfGamesDecrementDuringGamePlay(){
        game = new Game();
        Player player = new Player("", "", 1, 0, 0, 0);
        game.playGame(player);
        Assert.assertEquals(0, player.getTotalNumberOfGamesAvailableToPlay());
    }

    @Test
    public void testEqualsAndHashcode(){
        Game game = new Game(true);
        Game sameGame = new Game(true);
        Game similarGame = new Game(false);

        Assert.assertTrue(game.equals(sameGame));
        Assert.assertTrue(game.hashCode() == sameGame.hashCode());

        Assert.assertFalse(game.equals(null));
        Assert.assertFalse(game.equals(similarGame));
        Assert.assertTrue(game.hashCode() != similarGame.hashCode());
    }

}
