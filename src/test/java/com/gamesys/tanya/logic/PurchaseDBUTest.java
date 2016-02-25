package com.gamesys.tanya.logic;

import com.gamesys.tanya.api.Purchase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;

public class PurchaseDBUTest {
    private PurchaseDB db;

    @Before
    public void setUp() {
        db = new PurchaseDB();
    }

    @After
    public void tearDown() {
        db.removeAllPurchases();
    }

    @Test
    public void testIsMapEmpty() {
        Assert.assertThat(db.isEmpty(), is(true));
    }

    @Test
    public void testMapIsNotEmpty() {
        Purchase purchase = new Purchase(1, 123, 3);
        db.savePurchase(purchase);
        Assert.assertThat(db.isEmpty(), is(false));
    }

    @Test
    public void saveNewPurchase(){
        Purchase purchase = new Purchase(1, 123, 3);
        db.savePurchase(purchase);
        Assert.assertThat(db.isEmpty(), is(false));
    }

    @Test
    public void testHowManyItemsInMap() {
        Purchase purchase1 = new Purchase(1, 123, 3);
        Purchase purchase2 = new Purchase(22, 456, 2);
        Purchase purchase3 = new Purchase(333, 789, 1);
        db.savePurchase(purchase1);
        db.savePurchase(purchase2);
        db.savePurchase(purchase3);
        Assert.assertEquals(db.getCount(), 3);
    }

    @Test
    public void testKeyExists() {
        Purchase purchase = new Purchase(1, 123, 3);
        db.savePurchase(purchase);
        Assert.assertTrue(db.doesIdExist(1));
    }

    @Test
    public void testKeyDoesntExist() {
        Assert.assertFalse(db.doesIdExist(1));
    }

    @Test
    public void testPurchaseIdNotInDB(){
        Assert.assertEquals("Purchase doesn't exist in DB", db.getByPurchaseId(2));
    }

    @Test
    public void testGetPurchaseById(){
        Purchase purchase = new Purchase(1, 123, 3);
        db.savePurchase(purchase);
        Assert.assertEquals("Purchase{purchaseId=1, memberId=123, numberOfTicketsPurchased=3}", db.getByPurchaseId(1));
    }

    @Test
    public void testGetAllPurchases(){
        Purchase purchase1 = new Purchase(1, 123, 3);
        Purchase purchase2 = new Purchase(22, 456, 2);
        Purchase purchase3 = new Purchase(333, 789, 1);
        db.savePurchase(purchase1);
        db.savePurchase(purchase2);
        db.savePurchase(purchase3);

        List<Purchase> list = new ArrayList<Purchase>();
        list.add(purchase1);
        list.add(purchase2);
        list.add(purchase3);

        Assert.assertEquals(list, db.getAll());
    }

//    TODO - Fix this
    @Test
    public void testForDuplicatedKeys(){
        Purchase purchase1 = new Purchase(1, 123, 3);
        Purchase purchase2 = new Purchase(1, 123, 3);
        db.savePurchase(purchase1);
        db.savePurchase(purchase2);
        Assert.assertTrue(db.doesIdExist(1));
    }
}
