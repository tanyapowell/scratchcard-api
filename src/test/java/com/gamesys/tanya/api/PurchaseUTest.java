package com.gamesys.tanya.api;

import com.gamesys.tanya.logic.PurchaseDB;
import org.junit.*;

public class PurchaseUTest {
    private Purchase purchase = new Purchase();

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    @Test
    public void testGetPurchaseId() {
        purchase.setPurchaseId(123);
        Assert.assertTrue(purchase.getPurchaseId() == 123);
    }

    @Test
    public void testPurchaseIdNotNull() {
        Assert.assertNotNull(new PurchaseDB());
    }

    @Test
    public void testGetPlayerId() {
        purchase.setPlayerId(456);
        Assert.assertEquals(456, purchase.getPlayerId());
    }

    @Test
    public void testGetNumberOfPurchasedTickets() {
        purchase.setNumberOfTicketsPurchased(5);
        Assert.assertTrue(purchase.getNumberOfTicketsPurchased() == 5);
    }

    @Test
    public void testEqualsAndHashcode() {
        Purchase purchase = new Purchase(22, 456, 2);
        Purchase samePurchase = new Purchase(22, 456, 2);
        Purchase similarPurchase = new Purchase(333, 789, 1);

        Assert.assertTrue(purchase.equals(samePurchase));
        Assert.assertTrue(purchase.hashCode() == samePurchase.hashCode());

        Assert.assertFalse(purchase.equals(null));
        Assert.assertFalse(purchase.equals(similarPurchase));
        Assert.assertTrue(purchase.hashCode() != similarPurchase.hashCode());
    }
}
