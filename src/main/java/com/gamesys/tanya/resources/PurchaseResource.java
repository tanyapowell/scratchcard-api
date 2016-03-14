package com.gamesys.tanya.resources;

import com.codahale.metrics.annotation.Timed;
import com.gamesys.tanya.api.Purchase;
import com.gamesys.tanya.logic.PurchaseDB;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/purchase")
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseResource {
    public PurchaseResource(PurchaseDB db) throws SQLException {
        db.createTable();
    }

    @GET
    @Timed
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPurchases() throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(PurchaseDB.getAll());

        return jsonList;
    }

    @GET
    @Timed
    @Path("/get_id/{purchaseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPurchaseId(@PathParam("purchaseId") long purchaseId) throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(PurchaseDB.getById(purchaseId));

        return jsonList;
    }

    @GET
    @Timed
    @Path("/get_player/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPlayerId(@PathParam("playerId") long playerId) throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(PurchaseDB.getByPlayer(playerId));

        return jsonList;
    }

    @POST
    @Timed
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public String addNewPurchase(Purchase purchase) throws SQLException {
        return PurchaseDB.save(purchase);
    }

}
