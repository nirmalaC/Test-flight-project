@Release:rel0.1
@Sprint:sprint_14
Feature: Retrieve languages information

  Scenario: Active languages are returned
    Given there are active languages
    When I call the get languages service
    Then the active languages are returned

  Scenario: Inactive languages are not returned
    Given there are inactive languages
    When I call the get languages service
    Then the inactive languages are not returned
