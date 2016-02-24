package com.gamesys.tanya;

import com.gamesys.tanya.api.Purchase;
import com.gamesys.tanya.logic.PurchaseDB;
import org.junit.*;

public class PurchaseUTest {
    private Purchase purchase = new Purchase();

    @Before
    public void setUp(){
        purchase.setPurchaseId(123);
        purchase.setMemberId(456);
        purchase.setNumberOfTicketsPurchased(5);
    }

    @After
    public void tearDown() {
        System.out.println("after");
    }

    @Test
    public void testGetPurchaseId(){
        Assert.assertTrue(purchase.getPurchaseId() == 123);
    }

    @Test
    public void testPurchaseIdNotNull(){
        Assert.assertNotNull(new PurchaseDB());
    }

    @Test
    public void testGetMemberId(){
        Assert.assertTrue(purchase.getMemberId() == 456);
    }

    @Test
    public void testGetNumberOfPurchasedTickets(){
        Assert.assertTrue(purchase.getNumberOfTicketsPurchased() == 5);
    }

    @Test
    public void testEquals(){

    }
}
