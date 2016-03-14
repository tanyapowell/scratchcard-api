package com.gamesys.tanya.logic;

import com.gamesys.tanya.api.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class PlayerDBUTest {
    PlayerDB database;

    @Before
    public void setUp(){
        database = new PlayerDB();
        database.createTable();
    }

    @After
    public void tearDown() throws SQLException {
        database.removeAllPlayers();
    }

    @Test
    public void testSavingPlayer(){

    }

}
