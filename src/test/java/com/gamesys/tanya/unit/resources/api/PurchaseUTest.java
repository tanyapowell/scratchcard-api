package com.gamesys.tanya.unit.resources.api;

import com.gamesys.tanya.api.Purchase;
import com.gamesys.tanya.logic.PurchaseDAO;
import org.junit.*;

public class PurchaseUTest {
    private Purchase purchase = new Purchase();

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    @Test
    public void testPurchaseIdNotNull() {
        Assert.assertNotNull(new PurchaseDAO());
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
        Purchase purchase = new Purchase(456, 2);
        Purchase samePurchase = new Purchase(456, 2);
        Purchase similarPurchase = new Purchase(789, 1);

        Assert.assertTrue(purchase.equals(samePurchase));
        Assert.assertTrue(purchase.hashCode() == samePurchase.hashCode());

        Assert.assertFalse(purchase.equals(null));
        Assert.assertFalse(purchase.equals(similarPurchase));
        Assert.assertTrue(purchase.hashCode() != similarPurchase.hashCode());
    }
}
