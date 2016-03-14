package com.gamesys.tanya.resources;

import com.gamesys.tanya.api.Purchase;
import com.gamesys.tanya.logic.PurchaseDB;
import com.google.gson.Gson;
import org.fest.assertions.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseResourceUTest {
    private PurchaseResource resource;
    private PurchaseDB database;

    @Before
    public void setUp() throws SQLException {
        database = new PurchaseDB();
        database.createTable();
        resource = new PurchaseResource(database);
    }

    @After
    public void tearDown() throws SQLException {
        try {
            database.dropTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetAll() throws SQLException {
        Purchase purchase1 = new Purchase(1, 123, 3);
        Purchase purchase2 = new Purchase(22, 456, 2);
        Purchase purchase3 = new Purchase(444, 789, 1);
        Purchase purchase4 = new Purchase(55, 789, 1);
        Purchase purchase5 = new Purchase(6, 789, 1);
        PurchaseDB.save(purchase1);
        PurchaseDB.save(purchase2);
        PurchaseDB.save(purchase3);
        PurchaseDB.save(purchase4);
        PurchaseDB.save(purchase5);

        List<Purchase> list = new ArrayList<>();
        list.add(purchase1);
        list.add(purchase2);
        list.add(purchase3);
        list.add(purchase4);
        list.add(purchase5);

        Gson gson = new Gson();
        String jsonList = gson.toJson(list);

        Assert.assertEquals(jsonList.contains(resource.getPurchases()), resource.getPurchases().contains(jsonList));
    }

    @Test
    public void testGetPurchaseById() throws SQLException {
        Purchase purchase1 = new Purchase(1, 123, 3);
        Purchase purchase2 = new Purchase(22, 456, 2);
        Purchase purchase3 = new Purchase(444, 789, 1);
        PurchaseDB.save(purchase1);
        PurchaseDB.save(purchase2);
        PurchaseDB.save(purchase3);

        List<Purchase> list = new ArrayList<>();
        list.add(purchase2);

        Gson gson = new Gson();
        String jsonList = gson.toJson(list);

        Assert.assertEquals(jsonList, resource.getPurchaseId(22));
    }

    @Test
    public void testGetPlayerById() throws SQLException {
        Purchase purchase1 = new Purchase(1, 123, 3);
        Purchase purchase2 = new Purchase(22, 456, 2);
        Purchase purchase3 = new Purchase(444, 789, 1);
        PurchaseDB.save(purchase1);
        PurchaseDB.save(purchase2);
        PurchaseDB.save(purchase3);

        List<Purchase> list = new ArrayList<>();
        list.add(purchase3);

        Gson gson = new Gson();
        String jsonList = gson.toJson(list);

        Assert.assertEquals(jsonList, resource.getPlayerId(789));
    }

    @Test
    public void testSavePurchase() throws SQLException {
        Purchase purchase = new Purchase(1, 123, 3);
        String save = resource.addNewPurchase(purchase);

        Assertions.assertThat(save).isEqualTo("Purchase has been saved");
    }
}
