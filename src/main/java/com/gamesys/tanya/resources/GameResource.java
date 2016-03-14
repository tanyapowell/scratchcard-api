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
    @Path("/get_id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getById(@PathParam("id") int id) throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(GameDB.getById(id));

        return jsonList;
    }

    @GET
    @Timed
    @Path("/get_player/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByPlayer(@PathParam("playerId") long id) throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(GameDB.getByPlayerId(id));

        return jsonList;
    }

}
