package com.gamesys.tanya.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Purchase {
    private long purchaseId;
    private long memberId;
    private int numberOfTicketsPurchased;

    public Purchase() {}

    public Purchase(int purchaseId, int memberId, int numberOfTicketsPurchased){
        this.purchaseId = purchaseId;
        this.memberId = memberId;
        this.numberOfTicketsPurchased = numberOfTicketsPurchased;
    }

    @JsonProperty
    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    @JsonProperty
    public long getMemberId() { return memberId; }

    public void setMemberId(long memberId) { this.memberId = memberId; }

    @JsonProperty
    public int getNumberOfTicketsPurchased() { return numberOfTicketsPurchased; }

    public void setNumberOfTicketsPurchased(int numberOfTicketsPurchased) {
        this.numberOfTicketsPurchased = numberOfTicketsPurchased;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", memberId=" + memberId +
                ", numberOfTicketsPurchased=" + numberOfTicketsPurchased +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (purchaseId != purchase.purchaseId) return false;
        if (memberId != purchase.memberId) return false;
        return numberOfTicketsPurchased == purchase.numberOfTicketsPurchased;

    }

    @Override
    public int hashCode() {
        int result = (int) (purchaseId ^ (purchaseId >>> 32));
        result = 31 * result + (int) (memberId ^ (memberId >>> 32));
        result = 31 * result + numberOfTicketsPurchased;
        return result;
    }
}
