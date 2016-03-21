package com.gamesys.tanya.resources;

import com.codahale.metrics.annotation.Timed;
import com.gamesys.tanya.api.Game;
import com.gamesys.tanya.logic.GameDB;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/games")
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {
    public GameResource(GameDB db) throws SQLException {
        db.createTable();
        Game game1 = new Game(1234, 453241);
        Game game2 = new Game(2315, 123241);
        Game game3 = new Game(3890, 563241);
        Game game4 = new Game(4255, 695379);
        Game game5 = new Game(6932, 897642);
        Game game6 = new Game(8003, 789649);
        GameDB.saveGameResults(game1);
        GameDB.saveGameResults(game2);
        GameDB.saveGameResults(game3);
        GameDB.saveGameResults(game4);
        GameDB.saveGameResults(game5);
        GameDB.saveGameResults(game6);
    }

    @GET
    @Timed
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getGames() throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(GameDB.getAll());

        return jsonList;
    }

    @POST
    @Timed
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public String addNewGame(Game game) throws SQLException {
        return GameDB.saveGameResults(game);
    }

    @GET
    @Timed
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getById(@PathParam("id") int id) throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(GameDB.getById(id));

        return jsonList;
    }

    @GET
    @Timed
    @Path("/player/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByPlayer(@PathParam("playerId") long id) throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(GameDB.getByPlayerId(id));

        return jsonList;
    }

}
