package com.gamesys.tanya.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Purchase {
    private long purchaseId;
    private long playerId;
    private int numberOfTicketsPurchased;

    public Purchase() {}

    public Purchase(int purchaseId, long playerId, int numberOfTicketsPurchased){
        this.purchaseId = purchaseId;
        this.playerId = playerId;
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
    public long getPlayerId() { return playerId; }

    public void setPlayerId(long playerId) { this.playerId = playerId; }

    @JsonProperty
    public int getNumberOfTicketsPurchased() { return numberOfTicketsPurchased; }

    public void setNumberOfTicketsPurchased(int numberOfTicketsPurchased) {
        this.numberOfTicketsPurchased = numberOfTicketsPurchased;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", playerId=" + playerId +
                ", numberOfTicketsPurchased=" + numberOfTicketsPurchased +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (purchaseId != purchase.purchaseId) return false;
        if (playerId != purchase.playerId) return false;
        return numberOfTicketsPurchased == purchase.numberOfTicketsPurchased;

    }

    @Override
    public int hashCode() {
        int result = (int) (purchaseId ^ (purchaseId >>> 32));
        result = 31 * result + (int) (playerId ^ (playerId >>> 32));
        result = 31 * result + numberOfTicketsPurchased;
        return result;
    }
}
