Feature: Registering a new player

  Scenario: Entering new players details into system
    Given I am not an existing user
    And my details are not on the system
    Then I should be able to register as a new player