package com.gamesys.tanya.cucumber.steps.steps;

import com.gamesys.tanya.api.Player;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class NewPlayerSteps {
    @Given("^I am not an existing user$")
    public void i_am_not_an_existing_user() throws Throwable {
        Player player = new Player();

        throw new PendingException();
    }

    @And("^my details are not on the system$")
    public void my_details_are_not_on_the_system() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should be able to register as a new player$")
    public void i_should_be_able_to_register_as_a_new_player() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}