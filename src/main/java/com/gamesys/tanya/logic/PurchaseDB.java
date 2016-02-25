package com.gamesys.tanya.logic;

import com.gamesys.tanya.api.Purchase;

import java.util.*;

public class PurchaseDB {
    private static Map<Long, Purchase> purchases = new HashMap<Long, Purchase>();

    public static void savePurchase(Purchase purchase) {
        if(doesIdExist(purchase.getPurchaseId()) != true) {
            purchases.put(purchase.getPurchaseId(), purchase);
        }
        else {
            System.out.println("Key already exists");
        }
    }

    public static Purchase getByMemberId(Purchase memberId) {
        return purchases.get(memberId);
    }

    public static List<Purchase> getAll() {
        List<Purchase> result = new ArrayList<Purchase>();
        for (Long key : purchases.keySet()) {
            result.add(purchases.get(key));
        }
        return result;
    }

    public static int getCount() {
        return purchases.size();
    }

    public boolean isEmpty() {
        boolean result;

        if (purchases.isEmpty()) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    public static boolean doesIdExist(long purchaseId) {
        boolean result;

        if (purchases.containsKey(purchaseId)) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    public static String getByPurchaseId(long purchaseId) {
        String result = "";
        Purchase value = purchases.get(purchaseId);

        if (value != null) {
            result = value.toString();
        } else {
            result = "Purchase doesn't exist in DB";
        }

        return result;
    }

    public void removeAllPurchases(){
        purchases.clear();
    }
}
