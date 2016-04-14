package com.gamesys.tanya.unit.resources;

import com.gamesys.tanya.api.Purchase;
import com.gamesys.tanya.logic.PurchaseDAO;
import com.gamesys.tanya.resources.PurchaseResource;
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
    private PurchaseDAO database;

    @Before
    public void setUp() throws SQLException {
        database = new PurchaseDAO();
//        database.createTable();
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
        Purchase purchase1 = new Purchase(123, 3);
        Purchase purchase2 = new Purchase(456, 2);
        Purchase purchase3 = new Purchase(789, 1);
        Purchase purchase4 = new Purchase(789, 1);
        Purchase purchase5 = new Purchase(789, 1);
        PurchaseDAO.save(purchase1);
        PurchaseDAO.save(purchase2);
        PurchaseDAO.save(purchase3);
        PurchaseDAO.save(purchase4);
        PurchaseDAO.save(purchase5);

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
        Purchase purchase1 = new Purchase(123, 3);
        Purchase purchase2 = new Purchase(456, 2);
        Purchase purchase3 = new Purchase(789, 1);
        PurchaseDAO.save(purchase1);
        PurchaseDAO.save(purchase2);
        PurchaseDAO.save(purchase3);

        List<Purchase> list = new ArrayList<>();
        list.add(purchase2);

        Gson gson = new Gson();
        String jsonList = gson.toJson(list);

        Assert.assertEquals(jsonList, resource.getPurchaseId(22));
    }

    @Test
    public void testGetPlayerById() throws SQLException {
        Purchase purchase1 = new Purchase(123, 3);
        Purchase purchase2 = new Purchase(456, 2);
        Purchase purchase3 = new Purchase(789, 1);
        PurchaseDAO.save(purchase1);
        PurchaseDAO.save(purchase2);
        PurchaseDAO.save(purchase3);

        List<Purchase> list = new ArrayList<>();
        list.add(purchase3);

        Gson gson = new Gson();
        String jsonList = gson.toJson(list);

        Assert.assertEquals(jsonList, resource.getPlayerId(789));
    }

    @Test
    public void testSavePurchase() throws SQLException {
        Purchase purchase = new Purchase(123, 3);
        String save = resource.addNewPurchase(purchase);

        Assertions.assertThat(save).isEqualTo("Purchase has been saved");
    }

    @Test
    public void testRemovePurchase() throws SQLException {
        Purchase purchase1 = new Purchase(123, 3);
        Purchase purchase2 = new Purchase(234, 6);
        PurchaseDAO.save(purchase1);
        PurchaseDAO.save(purchase2);

        String remove = resource.removePurchase(1);
        Assertions.assertThat(remove).isEqualTo(String.format("Purchase %d has been removed", 1));
    }
}
