package com.gamesys.tanya.unit.resources;

import com.gamesys.tanya.logic.GameDAO;
import com.gamesys.tanya.resources.GameResource;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.sql.SQLException;

public class GameResourceUTest {
    private GameResource resource;
    private GameDAO database;
//    HttpClient client = new HttpClient();

    @Before
    public void setUp() throws SQLException, IOException {
        database = new GameDAO();
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
//        GameDAO.saveGameResults(game1);
//        GameDAO.saveGameResults(game2);
//        GameDAO.saveGameResults(game3);
//        GameDAO.saveGameResults(game4);
//        GameDAO.saveGameResults(game5);
//        GameDAO.saveGameResults(game6);
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

//    @Test
//    public void testSavingGame() throws SQLException {
//        Game game = new Game(5555, 453241);
//        String save = resource.addNewGame(5555, game.getPlayerId());
//
//        Assertions.assertThat(save).isEqualTo("Game has been saved");

//        Response response = this.client.get("http://localhost:8080/games/save");
//        Assert.assertEquals(getResponseDetails(response), 200, response.getStatus());
//    }

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
//        GameDAO.saveGameResults(game1);
//        GameDAO.saveGameResults(game2);
//        GameDAO.saveGameResults(game3);
//        GameDAO.saveGameResults(game4);
//        GameDAO.saveGameResults(game5);
//        GameDAO.saveGameResults(game6);
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
//        GameDAO.saveGameResults(game1);
//        GameDAO.saveGameResults(game2);
//        GameDAO.saveGameResults(game3);
//        GameDAO.saveGameResults(game4);
//        GameDAO.saveGameResults(game5);
//        GameDAO.saveGameResults(game6);
//
//        list.add(game1);
//
//        Gson gson = new Gson();
//        String jsonList = gson.toJson(list);
//
//        Assert.assertEquals(jsonList, resource.getByPlayer(453241));
//    }

//    @Test
//    public void testRemoveGame() throws SQLException {
//        Game game1 = new Game(12345, 453241);
//        Game game2 = new Game(23157, 123241);
//        GameDAO.saveGameResults(game1);
//        GameDAO.saveGameResults(game2);
//
//        String remove = resource.removeGame(12345);
//        Assertions.assertThat(remove).isEqualTo(String.format("Game %d has been removed", 12345));
//    }
}
