@Release:rel0.1
@Sprint:sprint_14
@issue:FCPH-496
Feature: Retrieve Passenger Types

  Scenario: All passenger types can be returned
    Given there are passsenger types
    When I call the get passenger types service
    Then the passenger types are returned

  @manual
  Scenario: Passenger types have age ranges
    Given there are passsenger types
    When I call the get passenger types service
    Then the minimum and maximum age for each passenger is correct

  @manual
  Scenario: Passenger types have maximum number available
    Given there are passsenger types
    When I call the get passenger types service
    Then the maximum number is correct for each passenger type