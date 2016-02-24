package com.gamesys.tanya.rescources;

import com.codahale.metrics.annotation.Timed;
import com.gamesys.tanya.api.Purchase;
import com.gamesys.tanya.logic.PurchaseDB;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/purchase")
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseResource {
    public PurchaseResource() {}

    @GET
    @Timed
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Purchase> getPurchases() {
        return PurchaseDB.getAll();
    }


    @GET
    @Timed
    @Path("/get/{purchaseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPurchaseId(@PathParam("purchaseId") Purchase purchaseId) {
        return null;//PurchaseDB.getByPurchaseId(purchaseId);
    }

    @GET
    @Timed
    @Path("/get/{memberId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Purchase getMemberId(@PathParam("memberId") Purchase memberId) {
        return PurchaseDB.getByMemberId(memberId);
    }

    @POST
    @Timed
    @Path("/savepurchase")
    @Produces(MediaType.APPLICATION_JSON)
    public String addNewPurchase(Purchase purchase) {
        return null;//PurchaseDB.savePurchase(purchase);
    }


}
