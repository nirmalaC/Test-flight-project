@Release:rel0.1
@Sprint:sprint_14
@issue:FCPH-202
@issue:FCPH-488
@issue:FCPH-494
Feature: Retrieve Airport information

  Scenario: Airports that are marked as inactive are not returned
    Given there are inactive airports
    When I call the get airports service
    Then the inactive airports are not returned

  Scenario: Airports that are marked as being active are returned
    Given there are active airports
    When I call the get airports service
    Then all the active airports are returned

  @manual
  Scenario: Airports have the correct country
    Given there are active airports
    When I call the get airports service
    Then all airports have the correct country information

  @manual
  Scenario: Airports have the correct default currency
    Given there are active airports
    When I call the get airports service
    Then all airports have the correct default currency

  @manual
  Scenario: I can see, for each airport, if online checkin and mobile checkin are available
    Given there are active airports
    When I call the get airports service
    Then I can see if online checkin is available at each airport
    And I can see if mobile checkin is available at each airport

  @manual
  Scenario: Localised names are provided for each airport
    When I call the get airports service
    Then all of the airports have localized names