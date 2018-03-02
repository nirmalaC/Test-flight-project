@Release:rel0.1
@Sprint:sprint_14
@issue:FCPH-498
Feature: Retrieve currency information

  Scenario: Active Currencies are returned
    Given there are active currencies
    When I call the get currencies service
    Then the active currencies are returned

  Scenario: Inactive currencies are not returnedWhen I call the get currencies service
    Given there are inactive currencies
    When I call the get currencies service
    Then the inactive currencies are not returned

  @Manual
  Scenario: Localized information is returned for each country