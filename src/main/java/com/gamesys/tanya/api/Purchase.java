package com.gamesys.tanya.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Purchase {
    private long playerId;
    private int numberOfTicketsPurchased;

    public Purchase() {}

    public Purchase(long playerId, int numberOfTicketsPurchased){
        this.playerId = playerId;
        this.numberOfTicketsPurchased = numberOfTicketsPurchased;
    }

    @JsonProperty
    public long getPlayerId() { return playerId; }

    public void setPlayerId(long playerId) { this.playerId = playerId; }

    @JsonProperty
    public int getNumberOfTicketsPurchased() { return numberOfTicketsPurchased; }

    public void setNumberOfTicketsPurchased(int numberOfTicketsPurchased) {
        this.numberOfTicketsPurchased = numberOfTicketsPurchased;
    }

    @JsonProperty
    public void buyGameTickets(int tickets){
        setNumberOfTicketsPurchased(tickets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (playerId != purchase.playerId) return false;
        return numberOfTicketsPurchased == purchase.numberOfTicketsPurchased;

    }

    @Override
    public int hashCode() {
        int result = (int) (playerId ^ (playerId >>> 32));
        result = 31 * result + numberOfTicketsPurchased;
        return result;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "playerId=" + playerId +
                ", numberOfTicketsPurchased=" + numberOfTicketsPurchased +
                '}';
    }
}
