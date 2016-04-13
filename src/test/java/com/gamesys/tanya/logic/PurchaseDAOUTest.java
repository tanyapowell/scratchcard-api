package com.gamesys.tanya.logic;

import com.gamesys.tanya.api.Purchase;
import org.junit.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class PurchaseDAOUTest {
    private static PurchaseDAO database;

    @Before
    public void setUp() throws SQLException {
        database = new PurchaseDAO();
        database.createTable();
    }

    @After
    public void tearDown() throws SQLException {
        database.dropTable();
    }

    @Test
    public void testDatabaseIsEmpty() throws SQLException {
        Assert.assertThat(database.isEmpty(), is(true));
    }

    @Test
    public void testSavingPurchase() throws SQLException {
        Purchase purchase = new Purchase(789, 55);
        PurchaseDAO.save(purchase);

        Assert.assertThat(database.isEmpty(), is(false));
    }

    @Test
    public void testGetAll() throws SQLException {
        Purchase purchase1 = new Purchase(789, 4);
        Purchase purchase2 = new Purchase(325, 5);
        Purchase purchase3 = new Purchase(789, 3);
        Purchase purchase4 = new Purchase(789, 3);
        Purchase purchase5 = new Purchase(789, 3);
        Purchase purchase6 = new Purchase(789, 3);
        PurchaseDAO.save(purchase1);
        PurchaseDAO.save(purchase2);
        PurchaseDAO.save(purchase3);
        PurchaseDAO.save(purchase4);
        PurchaseDAO.save(purchase5);
        PurchaseDAO.save(purchase6);

        List<Purchase> list = new ArrayList<>();
        list.add(purchase1);
        list.add(purchase2);
        list.add(purchase3);
        list.add(purchase4);
        list.add(purchase5);
        list.add(purchase6);

        Assert.assertTrue(list.containsAll(database.getAll()) && database.getAll().containsAll(list));
    }

    @Test
    public void testGetByPlayerID() throws SQLException {
        Purchase purchase1 = new Purchase(789, 4);
        Purchase purchase2 = new Purchase(325, 5);
        Purchase purchase3 = new Purchase(789, 3);
        PurchaseDAO.save(purchase1);
        PurchaseDAO.save(purchase2);
        PurchaseDAO.save(purchase3);

        List<Purchase> list = new ArrayList<>();
        list.add(purchase1);
        list.add(purchase3);

        Assert.assertTrue(list.containsAll(database.getByPlayer(789)) && database.getByPlayer(789).containsAll(list));
    }

    @Test
    public void testGetDatabaseCount() throws SQLException {
        Purchase purchase1 = new Purchase(789, 4);
        Purchase purchase2 = new Purchase(325, 5);
        Purchase purchase3 = new Purchase(789, 3);
        PurchaseDAO.save(purchase1);
        PurchaseDAO.save(purchase2);
        PurchaseDAO.save(purchase3);

        List<Purchase> list = new ArrayList<>();
        list.add(purchase1);
        list.add(purchase2);
        list.add(purchase3);

        Assert.assertEquals(list.size(), database.getTotalCount());
    }

    @Test
    public void testGetByID() throws SQLException {
        Purchase purchase1 = new Purchase(789, 4);
        Purchase purchase2 = new Purchase(325, 5);
        Purchase purchase3 = new Purchase(789, 3);
        PurchaseDAO.save(purchase1);
        PurchaseDAO.save(purchase2);
        PurchaseDAO.save(purchase3);

        List<Purchase> list = new ArrayList<>();
        list.add(purchase1);

        Assert.assertTrue(list.containsAll(database.getById(1)) && database.getById(1).containsAll(list));
    }

    @Test
    public void testRemovingPurchase() throws SQLException {
        Purchase purchase1 = new Purchase(789, 4);
        Purchase purchase2 = new Purchase(325, 5);
        Purchase purchase3 = new Purchase(789, 3);
        PurchaseDAO.save(purchase1);
        PurchaseDAO.save(purchase2);
        PurchaseDAO.save(purchase3);
        System.out.println("Before: "+ PurchaseDAO.getAll());

        PurchaseDAO.removeSinglePurchase(1);

        System.out.println("After: "+ PurchaseDAO.getAll());
        Assert.assertEquals("Purchase 1 has been removed", PurchaseDAO.removeSinglePurchase(1));
    }
}