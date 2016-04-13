package com.gamesys.tanya.resources;

import com.codahale.metrics.annotation.Timed;
import com.gamesys.tanya.logic.GameDAO;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/games")
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {
    public GameResource(GameDAO db) throws SQLException {
        db.createTable();
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
    }

    @GET
    @Timed
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getGames() throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(GameDAO.getAll());

        return jsonList;
    }

//    @POST
//    @Timed
//    @Path("/save")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String addNewGame(@PathParam("playerId")long player) throws SQLException {
//        Game game = new Game (player);
//        return GameDAO.saveGameResults(game);
//    }

    @GET
    @Timed
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getById(@PathParam("id") int id) throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(GameDAO.getById(id));

        return jsonList;
    }

    @GET
    @Timed
    @Path("/player/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByPlayer(@PathParam("playerId") long id) throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(GameDAO.getByPlayerId(id));

        return jsonList;
    }

    @DELETE
    @Timed
    @Path("/remove/{id}")
    @Produces(MediaType.TEXT_HTML)
    public String removeGame(@PathParam("id") long gameId) throws SQLException {
        return GameDAO.removeSingleGame(gameId);
    }
}
