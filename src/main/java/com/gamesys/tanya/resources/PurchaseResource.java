package com.gamesys.tanya.resources;

import com.codahale.metrics.annotation.Timed;
import com.gamesys.tanya.api.Purchase;
import com.gamesys.tanya.logic.PurchaseDB;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/purchase")
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseResource {
    public PurchaseResource(PurchaseDB db) throws SQLException {
        db.createTable();
        Purchase purchase1 = new Purchase(111, 123, 1);
        Purchase purchase2 = new Purchase(222, 234, 2);
        Purchase purchase3 = new Purchase(333, 345, 3);
        Purchase purchase4 = new Purchase(444, 456, 4);
        Purchase purchase5 = new Purchase(555, 567, 5);
        PurchaseDB.save(purchase1);
        PurchaseDB.save(purchase2);
        PurchaseDB.save(purchase3);
        PurchaseDB.save(purchase4);
        PurchaseDB.save(purchase5);
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
    @Path("/{purchaseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPurchaseId(@PathParam("purchaseId") long purchaseId) throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(PurchaseDB.getById(purchaseId));

        return jsonList;
    }

    @GET
    @Timed
    @Path("/player/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPlayerId(@PathParam("playerId") long playerId) throws SQLException {
        Gson gson = new Gson();
        String jsonList = gson.toJson(PurchaseDB.getByPlayer(playerId));

        return jsonList;
    }

    @POST
    @Timed
    @Path("/save")
    @Produces(MediaType.TEXT_HTML)
    public String addNewPurchase(Purchase purchase) throws SQLException {
        return PurchaseDB.save(purchase);
    }

    @DELETE
    @Timed
    @Path("/remove")
    @Produces(MediaType.TEXT_HTML)
    public String removePurchase(@PathParam("purchaseId") long purchaseId) throws SQLException {
        return PurchaseDB.removeSinglePurchase(purchaseId);
    }

}
