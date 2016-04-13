package com.gamesys.tanya.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.concurrent.atomic.AtomicInteger;

public class Player {
    private String firstName;
    private String lastName;
    private long id;
    private int totalNumberOfGamesAvailableToPlay;
    private int totalNumberOfGamesPlayed;
    private int numberOfWins;
    private int numberOfLosses;

    public Player(){}

    public Player(String firstName, String lastName, int totalGamesCanPlay, int totalGamesPlayed, int numberOfWins, int numberOfLosses) {
        this.id = getId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalNumberOfGamesAvailableToPlay = totalGamesCanPlay;
        this.totalNumberOfGamesPlayed = totalGamesPlayed;
        this.numberOfWins = numberOfWins;
        this.numberOfLosses = numberOfLosses;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty
    public int getTotalNumberOfGamesAvailableToPlay() {
        return totalNumberOfGamesAvailableToPlay;
    }

    public void setTotalNumberOfGamesAvailableToPlayAfterGamePlay() {
        --totalNumberOfGamesAvailableToPlay;
    }

    @JsonProperty
    public int getTotalNumberOfGamesPlayed() {
        return totalNumberOfGamesPlayed;
    }

    public void setTotalNumberOfGamesPlayed() {
        ++totalNumberOfGamesPlayed;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    @JsonProperty
    public void setNumberOfWins() {
        ++numberOfWins;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    @JsonProperty
    public void setNumberOfLosses() {
        ++numberOfLosses;
    }

    public int buyTickets(int numberOfGameTicketsBought){
        Purchase purchase = new Purchase();
        purchase.buyGameTickets(numberOfGameTicketsBought);

        return  totalNumberOfGamesAvailableToPlay = totalNumberOfGamesAvailableToPlay + numberOfGameTicketsBought;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (id != player.id) return false;
        if (totalNumberOfGamesAvailableToPlay != player.totalNumberOfGamesAvailableToPlay) return false;
        if (totalNumberOfGamesPlayed != player.totalNumberOfGamesPlayed) return false;
        if (numberOfWins != player.numberOfWins) return false;
        if (numberOfLosses != player.numberOfLosses) return false;
        if (firstName != null ? !firstName.equals(player.firstName) : player.firstName != null) return false;
        return lastName != null ? lastName.equals(player.lastName) : player.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + totalNumberOfGamesAvailableToPlay;
        result = 31 * result + totalNumberOfGamesPlayed;
        result = 31 * result + numberOfWins;
        result = 31 * result + numberOfLosses;
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", totalNumberOfGamesAvailableToPlay=" + totalNumberOfGamesAvailableToPlay +
                ", totalNumberOfGamesPlayed=" + totalNumberOfGamesPlayed +
                ", numberOfWins=" + numberOfWins +
                ", numberOfLosses=" + numberOfLosses +
                '}';
    }
}
